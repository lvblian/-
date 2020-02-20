package com.blblog.qa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import entity.BlblogProblem;

import java.util.List;

/**
 * <p>
 * 问题 服务类
 * </p>
 *
 * @author lbl
 * @since 2020-01-20
 */
public interface BlblogProblemService extends IService<BlblogProblem> {

    Page<BlblogProblem> newList(Long labelid, Integer page, Integer limit);
}
