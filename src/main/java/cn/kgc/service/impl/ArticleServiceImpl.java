package cn.kgc.service.impl;

import cn.kgc.utils.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.kgc.model.ArticleEntity;
import cn.kgc.service.ArticleService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * 
 * @author lx
 *    Article业务层实现类
 * @date 2019-12-22 16:59:59
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl extends BaseServiceImpl<ArticleEntity> implements ArticleService, PageProcessor {

    /**
     * 抓取的相关配置
     */
    private Site site=Site.me();


    /**
     * 启动爬虫的方法
     */
    @Override
    public void spider(){
        Spider.create(this)
                .addUrl("https://www.biduo.cc/biquge/1_1476/")
                .thread(30)
                .run();
    }

    /**
     * 解析页面 分为两种1.首页    2.详情页
     * @param page  页面源码对象
     */
    @Override
    public void process(Page page) {
        if(page.getUrl().toString().equals("https://www.biduo.cc/biquge/1_1476/")){
            //首页
            List<String> links = page.getHtml().xpath("//div[@id='list']/dl/dd/a").links().all();
            page.addTargetRequests(links); 
            //不入库处理
            page.getResultItems().setSkip(true);
        }else {
            //详情页
            String content = page.getHtml().xpath("//div[@id='content']/text(0)").toString();
            String title = page.getHtml().xpath("//div[@class='bookname']/h1/text(0)").toString();
            if (content.isEmpty()){
                //不入库
                page.getResultItems().setSkip(true);
            }
            try {
                boolean b = isTitleRepeat(title);
                if (!b) {

                    //不重复，入库
                    ArticleEntity articleEntity = new ArticleEntity();
                    articleEntity.setTitle(title);
                    articleEntity.setContent(content);
                    articleEntity.setMd5Key(MD5.md5crypt(title));
                    Integer insert = baseMapper.insert(articleEntity);
                    if (insert>0){
                        System.out.println("入库成功");
                    }else {
                        System.out.println("入库失败");
                    }
                }
                //章节标题重复,不入库
                page.getResultItems().setSkip(true);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 验证章节标题是否重复
     * @param title
     * @return
     */
    @Override
    public boolean isTitleRepeat(String title) throws Exception {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setMd5Key(MD5.md5crypt(title));
        Long count = baseMapper.queryTotalByPramas(articleEntity);
        if (count > 0) {
            //标题重复
            return true;
        }
        return false;
    }



    @Override
    public Site getSite() {
        return site;
    }
}
