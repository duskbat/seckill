package com.seckill.dao;

import com.seckill.entity.SuccessKilled;

/**
 * @description:
 * @author: muweiye
 * @createTime: 2019-11-05 01:22
 **/
public interface SuccessKilledDao {

    int insertSuccessKilled(long seckillId, long userPhone);

    /**
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId);
}
