# TLIAS Web 管理系统项目说明文档

## 项目概述

**项目名称**: TLIAS Web 管理系统  
**技术栈**: Spring Boot 3.5.4 + MyBatis + MySQL + Maven  
**Java版本**: JDK 17  
**项目描述**: 基于Spring Boot框架开发的Web管理系统，采用经典的三层架构设计模式，目前主要实现部门管理功能，后续将扩展更多业务模块

## 当前功能模块

✅ **部门管理模块** - 已完成
- 部门信息查询
- 基础CRUD操作框架
- RESTful API接口

🔄 **待开发模块** - 规划中
- 员工管理模块
- 权限管理模块
- 角色管理模块
- 菜单管理模块
- 日志管理模块

## 项目结构

```
tlias-web-management/
├── src/main/java/com/itheima/
│   ├── controller/          # 控制层
│   ├── service/            # 业务逻辑层
│   │   └── impl/          # 业务逻辑实现
│   ├── mapper/             # 数据访问层
│   └── pojo/              # 实体类
├── src/main/resources/     # 配置文件
└── pom.xml                # Maven依赖管理
```

## 三层架构详细说明

### 部门管理功能模块

#### 第一层：表现层（Controller Layer）

**位置**: `com.itheima.controller.DeptController`

**职责**:
- 接收前端HTTP请求
- 调用业务逻辑层处理请求
- 返回统一格式的响应结果

**核心功能**:
- 提供RESTful API接口 `/depts`
- 支持GET请求查询所有部门信息
- 使用`@RestController`注解标识为REST控制器
- 通过`@Autowired`自动注入业务逻辑层服务

**技术特点**:
- 使用Spring Boot的Web Starter
- 采用注解驱动开发
- 统一的响应结果封装

#### 第二层：业务逻辑层（Service Layer）

**接口位置**: `com.itheima.service.DeptService`  
**实现位置**: `com.itheima.service.impl.DeptServiceImpl`

**职责**:
- 定义部门管理业务操作规范
- 实现部门相关的业务逻辑
- 协调数据访问层和表现层

**核心功能**:
- 部门信息查询业务逻辑
- 部门业务规则验证和处理
- 部门事务管理（可扩展）

**技术特点**:
- 使用`@Service`注解标识为业务组件
- 通过接口和实现类分离，支持依赖注入
- 自动注入部门数据访问层Mapper

#### 第三层：数据访问层（Data Access Layer）

**位置**: `com.itheima.mapper.DeptMapper`

**职责**:
- 直接与数据库交互
- 执行部门相关的SQL查询和更新操作
- 将数据库结果映射为部门Java对象

**核心功能**:
- 部门数据的增删改查操作
- 部门数据库连接管理
- 部门结果集映射

**技术特点**:
- 使用MyBatis框架
- 支持注解和XML配置
- 自动类型转换和映射

### 后续功能模块架构设计

#### 员工管理功能模块（规划中）
- **表现层**: `EmployeeController` - 处理员工相关HTTP请求
- **业务逻辑层**: `EmployeeService` + `EmployeeServiceImpl` - 员工业务逻辑处理
- **数据访问层**: `EmployeeMapper` - 员工数据访问

#### 权限管理功能模块（规划中）
- **表现层**: `PermissionController` - 处理权限相关HTTP请求
- **业务逻辑层**: `PermissionService` + `PermissionServiceImpl` - 权限业务逻辑处理
- **数据访问层**: `PermissionMapper` - 权限数据访问

#### 角色管理功能模块（规划中）
- **表现层**: `RoleController` - 处理角色相关HTTP请求
- **业务逻辑层**: `RoleService` + `RoleServiceImpl` - 角色业务逻辑处理
- **数据访问层**: `RoleMapper` - 角色数据访问

### 通用架构规范

**命名规范**:
- 控制器：`[模块名]Controller`
- 服务接口：`[模块名]Service`
- 服务实现：`[模块名]ServiceImpl`
- 数据访问：`[模块名]Mapper`
- 实体类：`[模块名]`

**接口路径规范**:
- 部门管理：`/depts`
- 员工管理：`/employees`
- 权限管理：`/permissions`
- 角色管理：`/roles`

**扩展性设计**:
- 每层职责明确，便于维护和扩展
- 层与层之间通过接口交互，降低耦合度
- 支持新功能模块的快速集成
- 统一的代码命名规范，便于团队协作

## 数据模型层（POJO Layer）

### 部门管理实体类

**Dept.java** - 部门实体类
- `id`: 部门唯一标识
- `name`: 部门名称
- `createTime`: 创建时间
- `updateTime`: 更新时间

### 通用响应实体类

**Result.java** - 统一响应结果类
- `code`: 响应状态码（1成功，0失败）
- `msg`: 响应消息
- `data`: 响应数据

### 后续功能模块实体类（规划中）

**员工管理模块**:
- `Employee.java` - 员工实体类
  - `id`: 员工唯一标识
  - `name`: 员工姓名
  - `deptId`: 所属部门ID
  - `position`: 职位
  - `salary`: 薪资
  - `createTime`: 创建时间
  - `updateTime`: 更新时间

**权限管理模块**:
- `Role.java` - 角色实体类
  - `id`: 角色唯一标识
  - `name`: 角色名称
  - `description`: 角色描述
  - `createTime`: 创建时间
  - `updateTime`: 更新时间

- `Permission.java` - 权限实体类
  - `id`: 权限唯一标识
  - `name`: 权限名称
  - `code`: 权限代码
  - `type`: 权限类型
  - `createTime`: 创建时间
  - `updateTime`: 更新时间

**菜单管理模块**:
- `Menu.java` - 菜单实体类
  - `id`: 菜单唯一标识
  - `name`: 菜单名称
  - `path`: 菜单路径
  - `parentId`: 父菜单ID
  - `sort`: 排序
  - `createTime`: 创建时间
  - `updateTime`: 更新时间

**日志管理模块**:
- `Log.java` - 操作日志实体类
  - `id`: 日志唯一标识
  - `userId`: 操作用户ID
  - `operation`: 操作内容
  - `method`: 操作方法
  - `params`: 操作参数
  - `createTime`: 创建时间

### 实体类设计规范

**基础字段规范**:
- 统一使用Lombok注解简化代码
- 包含基础字段：`id`、`createTime`、`updateTime`
- 支持软删除和状态管理
- 使用驼峰命名法

**关联关系设计**:
- 支持一对一、一对多、多对多关系
- 使用外键关联，保持数据一致性
- 支持级联操作和延迟加载

## 配置文件说明

### application.yml
- **数据库配置**: MySQL连接信息
- **MyBatis配置**: ORM框架相关设置
- **应用名称**: tlias-web-management

### pom.xml
- **Spring Boot**: 3.5.4版本
- **MyBatis**: 3.0.5版本
- **MySQL**: 数据库驱动
- **Lombok**: 代码简化工具

## 技术架构优势

1. **分层清晰**: 每层职责明确，便于维护和扩展
2. **松耦合**: 层与层之间通过接口交互，降低耦合度
3. **可扩展**: 支持水平扩展和功能模块化
4. **标准化**: 遵循Spring Boot最佳实践
5. **统一响应**: 标准化的API响应格式
6. **模块化设计**: 支持新功能模块的快速集成
7. **命名规范**: 统一的代码命名规范，便于团队协作

## 开发规范

### 代码规范
- 使用Lombok简化代码
- 完善的注释说明
- 遵循RESTful API设计原则
- 统一的代码格式化

### 命名规范

**包命名**: `com.itheima.[模块名]`
**类命名**: 
- 控制器：`[模块名]Controller`
- 服务接口：`[模块名]Service`
- 服务实现：`[模块名]ServiceImpl`
- 数据访问：`[模块名]Mapper`
- 实体类：`[模块名]`

**方法命名**: 动词+名词，如`findAll`、`save`、`update`、`delete`
**变量命名**: 驼峰命名法，如`deptList`、`employeeName`

### 模块开发规范

**部门管理模块**（已完成）:
- 遵循三层架构设计
- 使用统一的命名规范
- 实现基础的CRUD操作

**后续模块开发**（规划中）:
- 员工管理模块：继承部门管理模块的开发规范
- 权限管理模块：实现RBAC权限模型
- 角色管理模块：支持角色分配和权限继承
- 菜单管理模块：实现动态菜单管理
- 日志管理模块：记录系统操作日志

## 部署说明

### 环境要求
- JDK 17+
- MySQL 8.0+
- Maven 3.6+
- 内存：2GB+

### 部署步骤
1. 确保MySQL数据库服务运行
2. 配置正确的数据库连接信息
3. 使用Maven构建项目：`mvn clean package`
4. 运行Spring Boot应用：`java -jar target/tlias-web-management-0.0.1-SNAPSHOT.jar`

### 配置说明
- 数据库连接配置在`application.yml`中
- 支持多环境配置（dev、test、prod）
- 可通过环境变量覆盖配置

## 扩展建议

### 短期扩展（1-2个月）
- 完善部门管理的CRUD操作
- 添加员工管理模块
- 实现基础的权限控制
- 集成日志系统

### 中期扩展（3-6个月）
- 添加角色管理模块
- 实现菜单权限管理
- 添加操作日志记录
- 集成单元测试框架

### 长期扩展（6个月以上）
- 实现完整的权限管理系统
- 添加工作流引擎
- 集成消息通知系统
- 添加数据统计和报表功能
- 配置Swagger API文档

### 技术架构扩展
- 引入Redis缓存
- 集成消息队列
- 添加分布式事务支持
- 实现微服务架构拆分 
