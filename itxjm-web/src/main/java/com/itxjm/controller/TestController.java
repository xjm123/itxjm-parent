package com.itxjm.controller;


import com.itxjm.entity.VideoType;
import com.itxjm.service.VideoTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    private static Logger log = Logger.getLogger(TestController.class);
    private static final String TEST="test";

    @Autowired
    private VideoTypeService videoTypeService;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(1111);
        return TEST;
    }
    @ResponseBody
    @RequestMapping("/getVideoTypeList")
    public List<VideoType> getVideoTypeList(){
        List<VideoType> listVideoType =  videoTypeService.getVideoType(null);
        for(VideoType vt:listVideoType){
//            System.out.println(vt.toString());
            log.info(vt.toString());
        }
        return listVideoType;
    }
}
