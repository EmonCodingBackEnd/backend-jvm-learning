-- 创建数据库
CREATE DATABASE IF NOT EXISTS jvmdb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- 使用数据库
use jvmdb;

-- 创建数据表
DROP TABLE IF EXISTS people;
CREATE TABLE people
(
    `id`   INT AUTO_INCREMENT COMMENT '',
    `name` VARCHAR(255) COMMENT '',
    `age`  INT COMMENT '',
    `sex`  VARCHAR(255) COMMENT '',
    `job`  VARCHAR(255) COMMENT '',
    PRIMARY KEY (id)
) COMMENT = '';
-- 初始化数据：建议配置为500条
INSERT INTO jvmdb.people (name,age,sex,job) VALUES
                                                ('张三','18','男','待定岗'),
                                                ('张三','18','男','待定岗');
