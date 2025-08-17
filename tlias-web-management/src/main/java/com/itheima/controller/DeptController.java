package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门控制层
 * Controller层，负责接收前端请求，调用Service层处理业务逻辑，返回响应结果
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    //添加日志
    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    // 自动注入DeptService实例
    // Controller向Spring容器请求DeptService实例
    @Autowired
    private DeptService deptService;
    
    //@RequestMapping(value = "/depts",method = RequestMethod.GET )
    // 定义GET请求接口"/depts"
    // Controller接收前端发送的GET请求
    @GetMapping
    public Result list(){
        // 打印日志信息
        log.info("查询全部的部门信息");
        //System.out.println("查询全部的部门信息");
        // 调用Service层方法获取部门列表数据
        // Controller向Service发送查询所有部门信息请求，并接收Service返回的部门列表数据
        List <Dept> deptList = deptService.findAll();
        // 将部门列表数据封装到统一响应结果中并返回给前端
        // Controller向前端返回封装了部门列表数据的统一响应结果
        return  Result.success(deptList);
    }

    //删除部门
    @DeleteMapping
    //方法一
//    public Result delete(HttpServletRequest  request){
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("根据id删除部门数据"+id);
//    }
    //方法二
//    public Result delete(@RequestParam("id") Integer deptId){
//        System.out.println("根据id删除部门数据"+deptId);
//        return Result.success();
//    }
    //方法三
    public Result delete( Integer id){
        log.info("根据id删除部门数据{}",id);
        //System.out.println("根据id删除部门数据"+id);
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public  Result add(@RequestBody Dept dept){
        //System.out.println("添加部门数据"+dept);
        log.info("添加部门数据{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("{id}")
    //根据id查询部门信息
//    public Result getIbfo(@PathVariable("id") Integer deptId){
//        System.out.println("查询部门数据"+deptId);
//        return.Result.success();
//    }
    //根据id查询部门信息
    public Result getIbfo(@PathVariable Integer id){
        System.out.println("查询部门数据"+id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改部门信息
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //System.out.println("修改部门数据"+dept);
        log.info("修改部门数据{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}