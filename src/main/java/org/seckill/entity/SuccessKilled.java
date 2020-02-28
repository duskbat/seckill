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

    /**
     * 商品id
     */
    private long seckillId;

    /**
     * 手机号
     */
    private long userPhone;

    /**
     * 订单状态
     */
    private short state;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 库存实体
     */
    private Seckill seckill;

}
