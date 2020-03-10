package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSuccessKillList() {
        List<Seckill> list = seckillService.getSuccessKillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void testSeckillLogic() {
        long id = 1000L;
        long phone = 15911134596L;

        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            String md5 = exposer.getMd5();
            SeckillExecution execution = null;
            try {
                execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("execution={}", execution);
            } catch (SeckillCloseException closeEx) {
                logger.info(closeEx.getMessage());
            } catch (RepeatKillException repeatEx) {
                logger.info(repeatEx.getMessage());
            }
        } else {
            logger.warn("exposer={}", exposer);
        }
    }
}