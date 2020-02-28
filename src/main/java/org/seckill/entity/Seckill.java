package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description: 商品库存
 * @author: muweiye
 * @createTime: 2019-11-05 00:47
 * <p>
 * 实体类的属性有基本int类型
 **/
@Data
public class Seckill {

    /**
     * 商品id
     */
    private Long seckillId;

    /**
     * 名称
     */
    private String name;

    /**
     * 库存数量
     */
    private int number;


    private Date startTime;

    private Date endTime;

    private Date createTime;
}
