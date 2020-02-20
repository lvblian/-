package com.blblog.qa.controller;


import com.blblog.qa.service.BlblogReplyService;
import entity.BlblogReply;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 回答 前端控制器
 * </p>
 *
 * @author lbl
 * @since 2020-01-20
 */
@RestController
@RequestMapping("/reply")
public class BlblogReplyController {
    @Autowired
    private BlblogReplyService blblogReplyService;

    //查询
    @GetMapping
    public Result findAll() {
        List<BlblogReply> list = blblogReplyService.list(null);
        return new Result(true, StatusCode.OK,"查询成功",list);
    }
    //根据ID查询
    @RequestMapping("{/id}")
    public Result findById(@PathVariable Long id) {
        BlblogReply blblogReply = blblogReplyService.getById(id);
        return new Result(true,StatusCode.OK,"查询成功",blblogReply);
    }
    //新增
    @PostMapping
    public Result addBlblogProblem(@RequestBody BlblogReply blblogProblem) {
        blblogReplyService.save(blblogProblem);
        return new Result(true,StatusCode.OK,"新增成功");
    }
    //修改
    @PutMapping
    public Result updateBlblogProblem(@RequestBody BlblogReply blblogReply) {
        blblogReplyService.updateById(blblogReply);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    //删除
    @DeleteMapping("{/id}")
    public Result removeById(@PathVariable Long id) {
        blblogReplyService.removeById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}

