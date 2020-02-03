package cn.kgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制
 *
 * @Author lx
 * @date 17:18
 */
@Controller
@RequestMapping("/model")
public class ModelController {

    /**
     * 去首页
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }
}
