-- 创建库存表
CREATE TABLE `seckill` (
    `seckill_id`    BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    `name`          VARCHAR(120) NOT NULL COMMENT '商品名称',
    `number`        INT(11) NOT NULL COMMENT '库存数量',
    `create_time`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `start_time`    TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '秒杀开始时间',
    `end_time`      TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '秒杀结束时间',
    PRIMARY KEY (`seckill_id`),
    KEY `idx_start_time` (`start_time`),
    KEY `idx_end_time` (`end_time`),
    KEY `idx_create_time` (`create_time`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='秒杀库存表';


-- 创建秒杀明细表
CREATE TABLE `success_killed` (
    id              BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `seckill_id`    BIGINT(20) NOT NULL COMMENT '秒杀商品ID',
    `user_phone`    BIGINT(20) NOT NULL COMMENT '用户手机号',
    `state`         TINYINT(4) NOT NULL DEFAULT '-1' COMMENT '状态标识 -1:无效 0:成功 1:已付款 2:已发货',
    `create_time`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`seckill_id` , `user_phone`),
    KEY `idx_create_time` (`create_time`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='秒杀成功明细表';


