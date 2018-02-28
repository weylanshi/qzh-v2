package com.huidong.qzh.nonstandard.controller;

import com.huidong.qzh.nonstandard.service.MaterialPriceService;
import com.huidong.qzh.nonstandard.service.PrintingPriceService;
import com.huidong.qzh.nonstandard.service.TechnicPriceService;
import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintingPriceController {

    @Autowired
    private MaterialPriceService materialPriceService;

    @Autowired
    private PrintingPriceService printingPriceService;

    @Autowired
    private TechnicPriceService technicPriceService;


    @RequestMapping("/getPrintingPrice")
    public QzhResult getPrintingPrice(@RequestParam("className") String className,
                                      @RequestParam("paperName") String paperName,
                                      @RequestParam("isDouble") String isDouble,
                                      @RequestParam("productNum") Integer productNum,
                                      @RequestParam("widthAndLen") String widthAndLen,
                                      @RequestParam("amount") Double amount,
                                      @RequestParam("yh") Integer yh) {
        Double totalBasePrice = 0.0;
        totalBasePrice += materialPriceService.getMaterialUnitPrice(className, paperName, productNum);
        totalBasePrice += printingPriceService.getPrintingPrice(className, isDouble, productNum);
        if (0 != yh) {
            totalBasePrice += technicPriceService.getTechnicPrice(className, widthAndLen, "yh", amount, yh);
        }
        return QzhResult.build(200,"OK", totalBasePrice);
    }


}
