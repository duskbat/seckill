package com.seckill.web;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.dto.SeckillResult;
import com.seckill.entity.Seckill;
import com.seckill.enums.SeckillStatEnum;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/seckill")
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> list = seckillService.getSuccessKillList();
        model.addAttribute("list", list);
        return "/list";
    }


    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "/detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
        SeckillResult<Exposer> seckillResult;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            seckillResult = new SeckillResult<>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            seckillResult = new SeckillResult<>(false, e.getMessage());
        }
        return seckillResult;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                   @CookieValue(value = "killPhone", required = false) Long userPhone,
                                                   @PathVariable("md5") String md5) {

        if (userPhone == null) {
            return new SeckillResult<>(false, "未注册");
        }
        SeckillResult<SeckillExecution> result;
        SeckillExecution execution;
        try {
            execution = seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
            result = new SeckillResult<>(true, execution);

        } catch (SeckillCloseException closeEx) {
            execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            result = new SeckillResult<>(true, execution);

        } catch (RepeatKillException repeatEx) {
            execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            result = new SeckillResult<>(true, execution);

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            result = new SeckillResult<>(false, execution);

        }
        return result;
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time() {
        Date now = new Date();
        return new SeckillResult<>(true, now.getTime());
    }
}
