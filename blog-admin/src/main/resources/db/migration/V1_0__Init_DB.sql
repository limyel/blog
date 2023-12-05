CREATE TABLE `sys_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
    `password` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
    `avatar` varchar(256) COLLATE utf8mb4_bin DEFAULT '' COMMENT '头像',
    `gender` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '性别，0：男，1：女，2：保密',
    `email` varchar(128) COLLATE utf8mb4_bin DEFAULT '' COMMENT '邮箱',
    `mobile` varchar(128) COLLATE utf8mb4_bin DEFAULT '' COMMENT '手机号',
    `super_admin` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否是超级管理员',
    `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态，0：停用，1：正常',
    `remark` varchar(512) COLLATE utf8mb4_bin DEFAULT '' COMMENT '备注',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统用户';



CREATE TABLE `sys_role` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(64) NOT NULL COMMENT '角色名称',
    `remark` varchar(128) DEFAULT '' COMMENT '备注',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统角色';



CREATE TABLE `sys_user_role` (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
     `user_id` bigint NOT NULL COMMENT '用户ID',
     `role_id` bigint NOT NULL COMMENT '角色ID',
     `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
     PRIMARY KEY (`id`) USING BTREE,
     UNIQUE KEY `uk_user_role` (`user_id`, `role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户角色关联';


CREATE TABLE `sys_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `pid` bigint NOT NULL DEFAULT 0 COMMENT '上级菜单，一级菜单为0',
    `name` varchar(64) NOT NULL COMMENT '菜单名称',
    `path` varchar(256) DEFAULT '' COMMENT '菜单路由',
    `permission` varchar(512) DEFAULT '' COMMENT '权限标识，多个用逗号隔开',
    `type` tinyint unsigned NOT NULL COMMENT '类型，0：菜单，1：按钮',
    `icon` varchar(128) DEFAULT '#' COMMENT '图标',
    `sort` int unsigned default 0 COMMENT '排序',
    `visible` bit NOT NULL DEFAULT b'1' COMMENT '是否可见',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统菜单';


CREATE TABLE `sys_role_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `role_id` bigint NOT NULL COMMENT '角色ID',
    `menu_id` bigint NOT NULL COMMENT '菜单ID',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_role_menu` (`role_id`, `menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色菜单关联';


CREATE TABLE `sys_param` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `param_code` varchar(32) NOT NULL COMMENT '参数编码',
    `param_value` varchar(2048) NOT NULL COMMENT '参数值',
    `param_type` tinyint unsigned NOT NULL DEFAULT 1 COMMENT '类型，0:系统参数，1:非系统参数',
    `remark` varchar(256) DEFAULT '' COMMENT '备注',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='系统参数';


CREATE TABLE `sys_dict_type` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `dict_type` varchar(128) NOT NULL COMMENT '字典类型',
    `dict_name` varchar(256) NOT NULL COMMENT '字典名称',
    `sort` int unsigned default 0 COMMENT '排序',
    `remark` varchar(256) DEFAULT '' COMMENT '备注',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典类型';


CREATE TABLE `sys_dict_data` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `dict_type_id` bigint NOT NULL COMMENT '字典类型ID',
    `dict_label` varchar(256) NOT NULL COMMENT '字典名称',
    `dict_value` varchar(256) DEFAULT '' COMMENT '字典值',
    `sort` int unsigned default 0 COMMENT '排序',
    `remark` varchar(256) DEFAULT '' COMMENT '备注',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_dict_type_value` (`dict_type_id`, `dict_value`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典数据';


CREATE TABLE `sys_oss` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `url` varchar(256) COLLATE utf8mb4_bin DEFAULT '' COMMENT 'URL地址',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='文件上传';



CREATE TABLE `sys_log_error` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `request_uri` varchar(256) COLLATE utf8mb4_bin DEFAULT '' COMMENT '请求URL',
    `request_method` varchar(32) COLLATE utf8mb4_bin DEFAULT '' COMMENT '请求方法',
    `request_param` text COLLATE utf8mb4_bin COMMENT '请求参数',
    `user_agent` varchar(512) COLLATE utf8mb4_bin DEFAULT '' COMMENT '用户代理',
    `ip` varchar(32) COLLATE utf8mb4_bin DEFAULT '' COMMENT '操作IP',
    `error_info` text COLLATE utf8mb4_bin COMMENT '异常信息',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='异常日志';



CREATE TABLE `sys_log_operation` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `operation` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户操作',
    `module` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '请求模块',
    `request_uri` varchar(256) COLLATE utf8mb4_bin DEFAULT '' COMMENT '请求URI',
    `request_method` varchar(32) COLLATE utf8mb4_bin DEFAULT '' COMMENT '请求方法',
    `request_param` text COLLATE utf8mb4_bin COMMENT '请求参数',
    `request_time` int unsigned NOT NULL COMMENT '请求时长（毫秒）',
    `user_agent` varchar(512) COLLATE utf8mb4_bin DEFAULT '' COMMENT '用户代理',
    `ip` varchar(32) COLLATE utf8mb4_bin DEFAULT '' COMMENT '操作IP',
    `result` text COLLATE utf8mb4_bin COMMENT '响应结果',
    `status` tinyint unsigned NOT NULL COMMENT '状态，0:失败，1:成功',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';



CREATE TABLE `sys_log_login` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `operation` tinyint unsigned NOT NULL COMMENT '用户操作，0:用户登录，1:用户退出',
    `user_agent` varchar(512) COLLATE utf8mb4_bin DEFAULT '' COMMENT '用户代理',
    `ip` varchar(32) COLLATE utf8mb4_bin DEFAULT '' COMMENT '操作IP',
    `status` tinyint unsigned NOT NULL COMMENT '状态，0:失败，1:成功，2:账号已锁定',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='登录日志';


CREATE TABLE `blog_post` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title` varchar(128) NOT NULL COMMENT '标题',
    `view_num` int DEFAULT '0' COMMENT '浏览量',
    `content` text DEFAULT NULL COMMENT '内容',
    `image` varchar(256) DEFAULT '' COMMENT '图片',
    `slug` varchar(256) DEFAULT NULL COMMENT '别名',
    `description` varchar(1024) DEFAULT NULL COMMENT '描述',
    `top` bit NOT NULL DEFAULT b'0' COMMENT '置顶',
    `draft` bit NOT NULL DEFAULT b'0' COMMENT '是否为草稿',
    `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='文章';


CREATE TABLE `blog_tag` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(64) NOT NULL COMMENT '名称',
    `slug` varchar(256) NOT NULL COMMENT '别名',
    `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态，0:禁用，1:启用',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `slug` (`slug`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='标签';


CREATE TABLE `blog_post_tag` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `post_id` bigint NOT NULL COMMENT '文章id',
    `tag_id` bigint NOT NULL COMMENT '标签id',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_post_tag` (`post_id`, `tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='文章标签';


CREATE TABLE `blog_link` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(64) NOT NULL COMMENT '名称',
    `description` varchar(256) DEFAULT '' COMMENT '描述',
    `link` varchar(256) NOT NULL COMMENT '链接',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='链接';


CREATE TABLE `blog_comment` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `sys_user_id` bigint DEFAULT NULL COMMENT '用户ID',
    `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
    `email` varchar(256) DEFAULT NULL COMMENT '邮箱',
    `post_id` bigint NOT NULL COMMENT '文章ID',
    `comment_id` bigint DEFAULT NULL COMMENT '目标评论ID',
    `content` varchar(2048) DEFAULT NULL COMMENT '内容',
    `status` tinyint DEFAULT '0' COMMENT '状态，0:待审核，1:审核通过，2:审核不通过',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='评论';


