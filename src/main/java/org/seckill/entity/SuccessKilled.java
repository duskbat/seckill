package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description: 秒杀明细
 * @author: muweiye
 * @createTime: 2019-11-05 00:55
 **/
@Data
public class SuccessKilled {

    private long seckillId;

    private long userPhone;

    private short state;

    private Date createTime;

    private Seckill seckill;

}
