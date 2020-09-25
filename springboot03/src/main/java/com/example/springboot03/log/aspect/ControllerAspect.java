package com.example.springboot03.log.aspect;

import com.example.springboot03.common.constant.LogConstant;
import com.example.springboot03.common.constant.SystemConstant;
import com.example.springboot03.log.annotation.ApiLogAnnotation;
import com.example.springboot03.log.dao.LogInterfaceRecordMapper;
import com.example.springboot03.log.model.LogInterfaceRecord;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 切面类
 * @author liqin
 * @date 2020/9/25 13:52
 */
@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Autowired
    private LogInterfaceRecordMapper recordMapper;

    /**
     * Pointcut 切点：在哪些地方切（发生的地方）
     */

    @Pointcut("@annotation(com.example.springboot03.log.annotation.ApiLogAnnotation)")
    public void logPointcut() {

    }

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        try {
            Object object = joinPoint.proceed();
            System.out.println(method.getName() + " 执行完毕！");
            return object;
        } catch (Exception ex) {
            System.out.println(method.getName() + " 执行失败！");
            throw ex;
        }
    }

    /**
     * 日志记录
     *
     * @param joinPoint 切
     * @return 权限结果
     */
    @Around("execution(* com.example.springboot03.api.controller.*.*(..) )")
    public Object apiLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1.保存访问日志
        saveLog(joinPoint);
        System.out.println("日志");
        Object result = joinPoint.proceed();
        System.out.println("日志保存后");
        return result;
    }


    private Object saveLog(ProceedingJoinPoint joinPoint) {
        LogInterfaceRecord logDo = null;
        try {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            logDo = new LogInterfaceRecord();
            logDo.setLogId(MDC.get(LogConstant.LOG_ID));
            logDo.setUrl(MDC.get(LogConstant.URL));
            logDo.setParams(MDC.get(LogConstant.PARAMS));
            logDo.setUserId(MDC.get(LogConstant.USER_ID));
            logDo.setMethodName(joinPoint.getTarget().getClass().getName() + "." + methodSignature.getMethod().getName());
            recordMapper.add(logDo);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("保存日志异常");
        }
        return logDo;
    }


    /**
     * 注解的方法 和 类
     */
    @Pointcut("@within(com.example.springboot03.log.annotation.ApiLogAnnotation)" +
            "&&@annotation(com.example.springboot03.log.annotation.ApiLogAnnotation)")
    private void rolePermission() {
    }

    /**
     * 角色权限控制
     *
     * @param joinPoint 切
     * @return 权限结果
     * @throws Throwable 异常
     */
    @Around("rolePermission()")
    public Object rolePermissionAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取角色id
        String roleId = MDC.get(SystemConstant.ROLE_ID);
        // 获取注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ApiLogAnnotation annotation = methodSignature.getMethod().getAnnotation(ApiLogAnnotation.class);
//        String[] permissionRoleId = annotation.roleId();
//        String permissionRoleIds = Arrays.toString(permissionRoleId);
//        // 1.角色限制
//        if (!permissionRoleIds.contains(ManagerRoleType.DEFAULT) && !permissionRoleIds.contains(roleId)) {
//            return ResponseVo.failed("权限不足！");
//        }
        return joinPoint.proceed();
    }

}
