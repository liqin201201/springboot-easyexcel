package com.example.springboot03.api.controller;

import com.alibaba.excel.EasyExcel;
import com.example.springboot03.dao.DeptDao;
import com.example.springboot03.entity.Department;
import com.example.springboot03.log.annotation.ApiLogAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author admin
 */
@Api(tags = "部门模块")
@RestController
public class DeptController {

    @Resource
    private DeptDao deptDao;

    @GetMapping("/dept/getDept")
    @ApiOperation("查询部门信息")
    @ApiLogAnnotation
    public List<Department> findAll() {
        return deptDao.findAll();
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        response.reset();
        response.setContentType("application/x-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("结果", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + ".xlsx\"");
        EasyExcel.write(response.getOutputStream(), Department.class).sheet("模板").doWrite(deptDao.findAll());
    }
}
