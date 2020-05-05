package com.seckill.exception;

/**
 * 重复秒杀异常
 * @author blinkbat
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
