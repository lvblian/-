package com.blblog.article.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blblog.article.service.BlblogArticleService;
import entity.BlblogArticle;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author lbl
 * @since 2020-01-19
 */
@RestController
@RequestMapping("articles")
//http://localhost:8080/blblog/articles?limit=15&page=1
//http://localhost:8080/blblog/articles
public class BlblogArticleController {

    @Autowired
    private BlblogArticleService blblogArticleService;

    /**
     * 分页条件查询
     * @param page
     * @param limit
     * BlblogDto :查询条件
     * @return
     */
    @PostMapping("{page}/{limit}")
    public Result pageQuery(@PathVariable Long page, @PathVariable Long limit, @RequestBody BlblogArticle blblogArticle) {
        //创建分页对象工具Page
        Page<BlblogArticle> articlePage = new Page<>(page,limit);
        //调用分页方法
        IPage<BlblogArticle> iPage = blblogArticleService.pageQuery(articlePage, blblogArticle);
        //获取返回结果
        List<BlblogArticle> records = iPage.getRecords();
        //获取总条数
        long total = iPage.getTotal();
        //创建返回分页结果对象
        PageResult<BlblogArticle> pageResult = new PageResult<>(total,records);
        //将对象返回
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
    }

    //分页查询
    @GetMapping("{page}/{limit}")
    public Result pageQuery(@PathVariable Long page, @PathVariable Long limit) {
        //创建分页对象工具Page
        Page<BlblogArticle> labelPage = new Page<>(page,limit);
        //调用分页方法
        IPage<BlblogArticle> iPage = blblogArticleService.page(labelPage, null);
        //获取返回结果
        List<BlblogArticle> records = iPage.getRecords();
        //获取总条数
        long total = iPage.getTotal();
        //创建返回分页结果对象
        PageResult<BlblogArticle> pageResult = new PageResult<>(total,records);
        //将对象返回
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    //查询列表
    @GetMapping
    public Result findAll() {
        List<BlblogArticle> blblogArticles = blblogArticleService.list(null);
        return new Result(true, StatusCode.OK,"查询成功",blblogArticles);
    }
    //根据ID查询
    @RequestMapping("{id}")
    public Result findById(@PathVariable Long id) {
        BlblogArticle article = blblogArticleService.getById(id);
        return new Result(true,StatusCode.OK,"查询成功",article);
    }
    //增加label
    @PostMapping
    public Result addArticle(@RequestBody BlblogArticle blblogArticle) {
        blblogArticleService.save(blblogArticle);
        return new Result(true,StatusCode.OK,"新增成功");
    }
    //修改
    @PutMapping
    public Result updateBlblogArticle(@RequestBody BlblogArticle blblogArticle) {
        blblogArticleService.updateById(blblogArticle);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    //根据id删除
    @DeleteMapping("{id}")
    public Result removeBlblogArticle(@PathVariable Long id) {
        blblogArticleService.removeById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}

