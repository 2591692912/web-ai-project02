package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门业务逻辑接口层
 * Service层接口，定义部门相关的业务操作规范
 */
public interface DeptService {

    /**
     * 查询所有部门信息
     * @return List<Dept> 部门列表数据
     * Service向Controller提供部门列表数据
     */
    List<Dept> findAll();

    void deleteById(Integer id);
}