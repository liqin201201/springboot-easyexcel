package com.example.springboot03.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author lq
 */
@Data
public class Department {
	@ExcelProperty("id")
	private Integer id;
	@ExcelProperty("部门名称")
	private String departmentName;

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + "]";
	}
	
}
