package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description: 商品库存
 * @author: muweiye
 * @createTime: 2019-11-05 00:47
 *
 * 实体类的属性有基本int类型
 **/
@Data
public class Seckill {

    private Long seckillId;

    private String name;

    private int number;

    private Date startTime;

    private Date endTime;

    private Date createTime;
}
