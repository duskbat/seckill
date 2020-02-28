package org.seckill.dao;

import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: muweiye
 * @createTime: 2019-11-05 01:00
 **/
public interface SeckillDao {

    //这里 date考虑到线程安全了吗
    int reduceNumber(long seckillId, Date killTime);

    Seckill queryById(long seckillId);

    List<Seckill> queryAll(int offset, int limit);
}
