package com.blblog.qa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blblog.qa.service.BlblogPlService;
import com.blblog.qa.service.BlblogProblemService;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 问题 前端控制器
 * </p>
 *
 * @author lbl
 * @since 2020-01-20
 */
@RestController
@RequestMapping("/problem")
public class BlblogProblemController {
    @Autowired
    private BlblogProblemService blblogProblemService;

    //最新回答列表
    @GetMapping("/newlist/{labelid}/{page}/{limit}")
    public Result newList(@PathVariable Long labelid,@PathVariable Integer page,@PathVariable Integer limit) {
        Page<BlblogProblem> blblogProblemPage = blblogProblemService.newList(labelid, page, limit);
        List<BlblogProblem> records = blblogProblemPage.getRecords();
        long total = blblogProblemPage.getTotal();
        PageResult<BlblogProblem> blblogProblemPageResult1 = new PageResult<>(total, records);
        return new Result(true,StatusCode.OK,"查询成功",blblogProblemPageResult1);
    }


    //查询
    @GetMapping
    public Result findAll() {
        List<BlblogProblem> list = blblogProblemService.list(null);
        return new Result(true, StatusCode.OK,"查询成功",list);
    }
    //根据ID查询
    @RequestMapping("{/id}")
    public Result findById(@PathVariable Long id) {
        BlblogProblem blblogProblem = blblogProblemService.getById(id);
        return new Result(true,StatusCode.OK,"查询成功",blblogProblem);
    }
    //新增
    @PostMapping
    public Result addBlblogProblem(@RequestBody BlblogProblem blblogProblem) {
        blblogProblemService.save(blblogProblem);
        return new Result(true,StatusCode.OK,"新增成功");
    }
    //修改
    @PutMapping
    public Result updateBlblogProblem(@RequestBody BlblogProblem blblogProblem) {
         blblogProblemService.updateById(blblogProblem);
         return new Result(true,StatusCode.OK,"修改成功");
    }
    //删除
    @DeleteMapping("{/id}")
    public Result removeById(@PathVariable Long id) {
        blblogProblemService.removeById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}

