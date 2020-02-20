package com.blblog.article.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import entity.BlblogArticle;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author lbl
 * @since 2020-01-19
 */
public interface BlblogArticleService extends IService<BlblogArticle> {

    IPage<BlblogArticle> pageQuery(Page<BlblogArticle> articlePage, BlblogArticle blblogArticle);
}
