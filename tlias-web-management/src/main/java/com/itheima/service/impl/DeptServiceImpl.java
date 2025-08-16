package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门业务逻辑实现层
 * Service层实现类，实现部门相关业务逻辑，调用Mapper层进行数据访问
 */
@Service
public class DeptServiceImpl implements DeptService {

    // 自动注入DeptMapper实例
    // Service向Spring容器请求DeptMapper实例
    @Autowired
    private DeptMapper deptMapper;
    
    /**
     * 实现查询所有部门信息的方法
     * @return List<Dept> 部门列表数据
     * Service向Mapper发送查询所有部门信息请求，并接收Mapper返回的部门列表数据
     * Service向Controller提供部门列表数据
     */
    @Override
    public List<Dept> findAll() {
        // 调用Mapper层方法查询所有部门数据
        // Service向Mapper发送查询所有部门信息请求
        return deptMapper.findALL();
        // Mapper向Service返回部门列表数据
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }
}