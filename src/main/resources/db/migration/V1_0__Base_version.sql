CREATE TABLE IF NOT EXISTS `post` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title` varchar(64) NOT NULL COMMENT '标题',
    `content` text COMMENT '内容',
    `slug` varchar(128) NOT NULL COMMENT 'slug',
    `status` smallint NOT NULL DEFAULT '1' COMMENT '状态，1:已发布 2:草稿',
    `description` varchar(512) DEFAULT NULL COMMENT '简述',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章';


CREATE TABLE IF NOT EXISTS `post_tag` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `post_id` bigint NOT NULL COMMENT 'post id',
    `tag_id` bigint NOT NULL COMMENT 'tag id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章标签关联';


CREATE TABLE IF NOT EXISTS `setting` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `about` text CHARACTER SET utf8mb4 NOT NULL COMMENT '名称',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设置';


CREATE TABLE IF NOT EXISTS `tag` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(32) NOT NULL COMMENT '名称',
    `slug` varchar(64) NOT NULL COMMENT 'slug',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签';


CREATE TABLE IF NOT EXISTS `user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` varchar(64) NOT NULL COMMENT '用户名',
    `password` varchar(512) NOT NULL COMMENT '密码',
    `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
    `super_admin` bit(1) NOT NULL DEFAULT b'0' COMMENT '超级管理员',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';


CREATE TABLE IF NOT EXISTS `user_token` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'token ID',
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `token` varchar(128) NOT NULL COMMENT 'token',
    `expired_time` datetime DEFAULT NULL COMMENT '过期时间',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_id` (`user_id`),
    UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='token';