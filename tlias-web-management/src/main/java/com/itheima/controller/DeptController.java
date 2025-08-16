package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门控制层
 * Controller层，负责接收前端请求，调用Service层处理业务逻辑，返回响应结果
 */
@RestController
public class DeptController {

    // 自动注入DeptService实例
    // Controller向Spring容器请求DeptService实例
    @Autowired
    private DeptService deptService;
    
    //@RequestMapping(value = "/depts",method = RequestMethod.GET )
    // 定义GET请求接口"/depts"
    // Controller接收前端发送的GET请求
    @GetMapping("/depts")
    public Result list(){
        // 打印日志信息
        System.out.println("查询全部的部门信息");
        // 调用Service层方法获取部门列表数据
        // Controller向Service发送查询所有部门信息请求，并接收Service返回的部门列表数据
        List <Dept> deptList = deptService.findAll();
        // 将部门列表数据封装到统一响应结果中并返回给前端
        // Controller向前端返回封装了部门列表数据的统一响应结果
        return  Result.success(deptList);
    }
}