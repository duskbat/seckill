package com.seckill.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author blinkbat
 */

@Getter
@AllArgsConstructor
public enum SeckillStatEnum {
    /**
     * 秒杀成功
     */
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据篡改 ");

    private int state;
    private String stateInfo;

    public static SeckillStatEnum stateOf(int index) {
        for (SeckillStatEnum statEnum : values()) {
            if (statEnum.getState() == index) {
                return statEnum;
            }
        }
        return null;
    }
}
