package com.blblog.label.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blblog.label.service.BlblogLabelService;
import dto.BlblogDto;
import entity.BlblogLabel;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 * 标签 前端控制器
 * </p>
 *
 * @author lbl
 * @since 2020-01-18
 */
@RestController
@RequestMapping("/label")
public class BlblogLabelController {

    @Autowired
    private BlblogLabelService blblogLabelService;

    /**
     * 分页条件查询
     * @param page
     * @param limit
     * BlblogDto :查询条件
     * @return
     */
    @PostMapping("{page}/{limit}")
    public Result pageQuery(@PathVariable Long page, @PathVariable Long limit, @RequestBody BlblogDto blblogDto) {
        //创建分页对象工具Page
        Page<BlblogLabel> labelPage = new Page<>(page,limit);
        //调用分页方法
        IPage<BlblogLabel> iPage = blblogLabelService.pageQuery(labelPage, blblogDto);
        //获取返回结果
        List<BlblogLabel> records = iPage.getRecords();
        //获取总条数
        long total = iPage.getTotal();
        //创建返回分页结果对象
        PageResult<BlblogLabel> pageResult = new PageResult<>(total,records);
        //将对象返回
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    //分页查询
    @GetMapping("{page}/{limit}")
    public Result pageQuery(@PathVariable Long page, @PathVariable Long limit) {
        //创建分页对象工具Page
        Page<BlblogLabel> labelPage = new Page<>(page,limit);
        //调用分页方法
        IPage<BlblogLabel> iPage = blblogLabelService.page(labelPage, null);
        //获取返回结果
        List<BlblogLabel> records = iPage.getRecords();
        //获取总条数
        long total = iPage.getTotal();
        //创建返回分页结果对象
        PageResult<BlblogLabel> pageResult = new PageResult<>(total,records);
        //将对象返回
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    //查询列表
    @GetMapping
    public Result findAll() {
        List<BlblogLabel> blblogLabels = blblogLabelService.list(null);
        return new Result(true, StatusCode.OK,"查询成功",blblogLabels);
    }
    //根据ID查询
    @RequestMapping("{id}")
    public Result findById(@PathVariable Long id) {
        BlblogLabel label = blblogLabelService.getById(id);
        return new Result(true,StatusCode.OK,"查询成功",label);
    }
    //增加label
    @PostMapping
    public Result addLabel(@RequestBody BlblogLabel blblogLabel) {
        blblogLabelService.save(blblogLabel);
        return new Result(true,StatusCode.OK,"新增成功");
    }
    //修改
    @PutMapping
    public Result updateBlblogLabel(@RequestBody BlblogLabel blblogLabel) {
        blblogLabelService.updateById(blblogLabel);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    //根据id删除
    @DeleteMapping("{id}")
    public Result removeBlblogLabel(@PathVariable Long id) {
        blblogLabelService.removeById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }


}

