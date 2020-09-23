package com.example.springboot03.controller;

import com.alibaba.excel.EasyExcel;
import com.example.springboot03.dao.DeptDao;
import com.example.springboot03.entity.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
@RestController
public class DeptController {
    @Resource
    private DeptDao deptDao;
    //查询部门信息
    @GetMapping("/dept")
    public List<Department> findAll(){
        return deptDao.findAll();
    }
    @GetMapping("/export")
    public void export(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.reset();
        response.setContentType("application/x-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("结果", "UTF-8");
//        String fileName = new String("结果".getBytes(),"iso8859-1");
//        String fileName = new String("结果".getBytes("UTF-8"),"iso8859-1");
//        String fileName = new String("结果".getBytes("gb2312"),"iso8859-1");
//        String fileName = new String("结果".getBytes("gbk"),"iso8859-1");

//        String fileName = new String("结果".getBytes());

        response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + ".xlsx\"");
        EasyExcel.write(response.getOutputStream(), Department.class).sheet("模板").doWrite(deptDao.findAll());
    }
}
