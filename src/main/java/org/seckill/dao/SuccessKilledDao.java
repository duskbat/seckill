package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

/**
 * @description:
 * @author: muweiye
 * @createTime: 2019-11-05 01:22
 **/
public interface SuccessKilledDao {

    int insertSuccessKilled(long seckillId, long userPhone);

    /**
     * 可以查出很多条记录，不止一条
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId);
}
