package com.seckill.exception;

/**
 * 秒杀异常
 * @author blinkbat
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
