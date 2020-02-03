package cn.kgc.service;

import cn.kgc.model.ArticleEntity;

/**
 * 
 * @author lx
 *    Article业务层接口
 * @date 2019-12-22 16:59:59
 */
public interface ArticleService extends BaseService<ArticleEntity>{


    /**
     * 验证章节标题是否重复
     * @param title
     * @return
     * @throws Exception
     */
    boolean isTitleRepeat(String title)throws Exception;


    /**
     * 启动爬虫的方法
     * @throws Exception
     */
    void spider()throws Exception;
	
}
