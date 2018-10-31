# soraka

- 前后端完全分离，基于Spring Boot 1.5.15.RELEASE
- 基于网关的统一权限管理，更高效更方便
- 基于`Spring Security OAuth`实现按钮级细粒度权限控制
- Apache LICENSE 2.0，完全开源

# 项目介绍
Soraka一个基于Spring Cloud的基础通用开发框架，有高效率，低封装的特点，非常适合学习和中小企业直接作为开发框架使用。

项目使用Maven进行管理，结构如下：

``` lua
soraka
├── soraka-admin -- 管理模块（端口：8003）
├── soraka-auth -- 权限模块（端口：8005）
├── soraka-common -- 共用模块
├── soraka-discovery -- 服务中心（端口：8001）
├── soraka-gateway -- ZUUL网关（端口：80）
├── soraka-weixin -- 微信模块（待实现 端口：8004）
```
前端项目链接：https://gitee.com/beiyoufx/soraka-view

- 用户管理：完整的用户管理授权体系
- 部门管理：配置系统组织机构，树结构展现，可随意调整上下级
- 菜单管理：配置系统菜单，操作权限，按钮权限标识，图标等
- 角色管理：角色菜单权限分配，最新的基于资源的权限控制（new RBAC）

#### 软件架构
软件架构说明
1. 运行环境：JDK 1.8.0_161
2. 主框架：Spring-boot 1.5.15.RELEASE
3. 微服务：Spring-cloud Edgware.SR4
4. 服务发现：Eureka
5. 网关：Zuul
6. 数据库：MySQL 5.7.16
7. 微服务文档：Swagger2 2.7.0
8. 安全框架：Spring Security OAuth

#### 安装教程

1. 需要Java环境，JDK1.8以上
2. 需要安装Maven
3. 需要MySQL数据库，数据库字符集utf-8mb4
4. 执行脚本`soraka\soraka-admin\soraka-init.sql`初始化数据库
5. 修改`soraka-admin`数据库地址
6. 依次启动`soraka-discovery`、`soraka-admin`、`soraka-auth`、`soraka-gateway`
7. 前端项目在：https://gitee.com/beiyoufx/soraka-view
