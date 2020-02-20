package com.blblog.label.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import dto.BlblogDto;
import entity.BlblogLabel;

/**
 * <p>
 * 标签 服务类
 * </p>
 *
 * @author lbl
 * @since 2020-01-18
 */
public interface BlblogLabelService extends IService<BlblogLabel> {

    IPage<BlblogLabel> pageQuery(Page<BlblogLabel> labelPage, BlblogDto blblogDto);
}
