package com.example.springboot03.dao;

import com.example.springboot03.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * @author admin
 */
@Mapper
public interface DeptDao {

    /**
     * 查询部门信息
     * @return
     */
    @Select("select * from department")
    public List<Department> findAll();
}
