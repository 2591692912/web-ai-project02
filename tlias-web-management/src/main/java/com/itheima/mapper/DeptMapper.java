package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门数据访问层接口
 * Mapper层接口，负责与数据库交互，执行SQL语句
 */
@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门信息
     * 通过注解方式定义SQL查询语句，按更新时间倒序排列
     * @return List<Dept> 部门列表数据
     * Mapper向Service提供部门列表数据
     */
//    @Results({
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc")
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findALL();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}