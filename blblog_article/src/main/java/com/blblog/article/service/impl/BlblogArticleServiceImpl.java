package com.blblog.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blblog.article.mapper.BlblogArticleMapper;
import com.blblog.article.service.BlblogArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import entity.BlblogArticle;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Date;
/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author lbl
 * @since 2020-01-19
 */
@Service
public class BlblogArticleServiceImpl extends ServiceImpl<BlblogArticleMapper, BlblogArticle> implements BlblogArticleService {
    @Override
    public IPage<BlblogArticle> pageQuery(Page<BlblogArticle> articlePage, BlblogArticle blblogArticle) {
        //获取查询条件
        String articleTitle = blblogArticle.getTitle();
        String type = blblogArticle.getType();
        Date createtime = blblogArticle.getCreatetime();
        Date updatetime = blblogArticle.getUpdatetime();
        QueryWrapper<BlblogArticle> queryWrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(articleTitle) || !StringUtils.isEmpty(type)) {
//            queryWrapper.like("labelname",labelname);
            queryWrapper.and(i -> i.like("title", articleTitle)
                    .or()
                    .like("type", type)
            );
        }
        IPage<BlblogArticle> labelIPage = baseMapper.selectPage(articlePage, queryWrapper);
        return labelIPage;
    }


}
