package com.blblog.qa.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.BlblogProblem;
import entity.PageResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 问题 Mapper 接口
 * </p>
 *
 * @author lbl
 * @since 2020-01-20
 */
public interface BlblogProblemMapper extends BaseMapper<BlblogProblem> {

    //查询最新回答列表
//    @Select("SELECT p.* FROM blblog_pl pl,blblog_problem p WHERE pl.labelid=#{labelid} AND p.id=pl.problemid ORDER BY replytime DESC")
    List<BlblogProblem> newList(@Param("labelid") Long labelid, Page<BlblogProblem>blblogProblemPage);

}
