package com.blblog.qa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blblog.qa.mapper.BlblogProblemMapper;
import com.blblog.qa.service.BlblogProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import entity.BlblogProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 问题 服务实现类
 * </p>
 *
 * @author lbl
 * @since 2020-01-20
 */
@Service
public class BlblogProblemServiceImpl extends ServiceImpl<BlblogProblemMapper, BlblogProblem> implements BlblogProblemService {

    @Autowired
    private BlblogProblemMapper blblogProblemMapper;

    @Override
    public Page<BlblogProblem> newList(Long labelid, Integer page, Integer limit) {
        //创建分页对象工具Page
        Page<BlblogProblem> blblogProblemPage = new Page<>(page,limit);

        List<BlblogProblem> blblogProblem = blblogProblemMapper.newList(labelid,blblogProblemPage);
        Page<BlblogProblem> problemPage = blblogProblemPage.setRecords(blblogProblem);
        return problemPage;
    }
}
