CREATE TABLE `admin` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
    `salt` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '加密盐',
    `password` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
    `site_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '网站标题',
    `sub_site_name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '网站副标题',
    `about` text COLLATE utf8mb4_bin COMMENT '关于',
    `remark` varchar(512) COLLATE utf8mb4_bin DEFAULT '' COMMENT '备注',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='管理员';


CREATE TABLE `main_post` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title` varchar(128) NOT NULL COMMENT '标题',
    `view_num` int NOT NULL DEFAULT '0' COMMENT '浏览量',
    `content` text DEFAULT NULL COMMENT '内容',
    `description` varchar(1024) DEFAULT NULL COMMENT '描述',
    `top` bit NOT NULL DEFAULT b'0' COMMENT '置顶',
    `comment` bit NOT NULL DEFAULT b'0' COMMENT '是否可评论',
    `draft` bit NOT NULL DEFAULT b'0' COMMENT '是否为草稿',
    `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='文章';


CREATE TABLE `main_tag` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(64) NOT NULL COMMENT '名称',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='标签';


CREATE TABLE `main_post_tag` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `post_id` bigint NOT NULL COMMENT '文章ID',
    `tag_id` bigint NOT NULL COMMENT '标签ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_post_tag` (`post_id`, `tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='文章标签';


CREATE TABLE `main_link` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(64) NOT NULL COMMENT '名称',
    `url` varchar(256) NOT NULL COMMENT '地址',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='链接';


CREATE TABLE `main_comment` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
    `email` varchar(256) DEFAULT NULL COMMENT '邮箱',
    `post_id` bigint NOT NULL COMMENT '文章ID',
    `pid` bigint DEFAULT NULL COMMENT '上级评论ID',
    `content` varchar(2048) DEFAULT NULL COMMENT '内容',
    `admin` bit NOT NULL DEFAULT b'0' COMMENT '是否为admin评论',
    `status` tinyint DEFAULT '0' COMMENT '状态，0:待审核，1:审核通过，2:审核不通过',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='评论';


