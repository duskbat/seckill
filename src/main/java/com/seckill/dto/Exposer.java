package com.seckill.dto;

import lombok.Data;

@Data
public class Exposer {

    /**
     * 是否开启秒杀活动
     */
    private boolean exposed;

    /**
     * md5加密
     */
    private String md5;

    /**
     * 秒杀id
     */
    private long seckillId;

    /**
     * 系统当前时间
     */
    private long now;

    /**
     * 开始秒杀时间
     */
    private long start;

    /**
     * 结束时间
     */
    private long end;

    /**
     * 成功暴露秒杀地址
     *
     * @param exposed
     * @param md5
     * @param seckillId
     */
    public Exposer(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    /**
     * 不在秒杀时间内
     *
     * @param exposed
     * @param seckillId
     * @param now
     * @param start
     * @param end
     */
    public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    /**
     * 不存在秒杀
     *
     * @param exposed
     * @param seckillId
     */
    public Exposer(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }
}
