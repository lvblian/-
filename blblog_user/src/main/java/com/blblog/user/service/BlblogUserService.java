package com.blblog.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import entity.BlblogUser;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author lbl
 * @since 2020-01-23
 */
public interface BlblogUserService extends IService<BlblogUser> {

    IPage<BlblogUser> pageQuery(Page<BlblogUser> userPage, BlblogUser blblogUser);

    void register(BlblogUser blblogUser);

    BlblogUser findUserByName(String username);
//    BlblogUser findUserByUserName(String username);
}
