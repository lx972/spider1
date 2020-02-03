package cn.kgc.controller;

import cn.kgc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import cn.kgc.model.ArticleEntity;
 
/**
 * 
 * @author lx
 *   Article控制器
 * @date 2019-12-22 16:59:59
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController<ArticleEntity>{

    /**
     * 注入业务层对象
     */
    @Autowired
    private ArticleService articleService;


    @RequestMapping("/start")
    public void start(){
        try {
            articleService.spider();
        } catch (Exception e) {
            System.out.println("启动爬虫失败");
            e.printStackTrace();
        }
    }

}
