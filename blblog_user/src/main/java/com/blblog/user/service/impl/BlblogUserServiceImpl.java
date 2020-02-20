package com.blblog.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blblog.user.mapper.BlblogUserMapper;
import com.blblog.user.service.BlblogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import entity.BlblogUser;
import enums.ExceptionEnum;
import exception.BlblogException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author lbl
 * @since 2020-01-23
 */
@Service
public class BlblogUserServiceImpl extends ServiceImpl<BlblogUserMapper, BlblogUser> implements BlblogUserService {

    @Autowired
    private BlblogUserMapper blblogUserMapper;

    /**
     * 条件分页查询
     * @param userPage
     * @param blblogUser
     * @return
     */
    @Override
    public IPage<BlblogUser> pageQuery(Page<BlblogUser> userPage, BlblogUser blblogUser) {
        if (!StringUtils.isEmpty(blblogUser)) {
            Long userId = blblogUser.getId();
            String userMobile = blblogUser.getMobile();
            String username = blblogUser.getUsername();
            QueryWrapper<BlblogUser> queryWrapper = new QueryWrapper();
            if (!StringUtils.isEmpty(userId) || !StringUtils.isEmpty(userMobile) || !StringUtils.isEmpty(username)){
                queryWrapper.and(i -> i.like("id", userId)
                        .or()
                        .like("mobile", userMobile)
                        .or()
                        .like("username", username)
                );

            }
            IPage<BlblogUser> userIPage = baseMapper.selectPage(userPage, queryWrapper);
            return userIPage;
        }
        throw new BlblogException(ExceptionEnum.PRICE_CANNOT_BE_NOLL);
    }

    /**
     * 用户注册
     * @param blblogUser
     */
    @Override
    public void register(BlblogUser blblogUser) {
        // 密码加密
        blblogUser.setPassword(BCrypt.hashpw(blblogUser.getPassword(),BCrypt.gensalt()));
        blblogUser.setFollowcount(0); // 关注数
        blblogUser.setFanscount(0);   // 粉丝数
        blblogUser.setOnline(0L);     // 在线时长
        blblogUser.setLastdate(new Date());   // 最后登录日期
        blblogUserMapper.insert(blblogUser);
    }

    @Override
    public BlblogUser findUserByName(String username) {
        QueryWrapper<BlblogUser> queryWrapper = new QueryWrapper();
        queryWrapper.and(i -> i.eq("username", username));
        BlblogUser blblogUser = baseMapper.selectOne(queryWrapper);
        return blblogUser;
    }

//    @Override
//    public BlblogUser findUserByUserName(String username) {
//        QueryWrapper<BlblogUser> queryWrapper = new QueryWrapper();
//        queryWrapper.and(i -> i.eq("username", username));
//        BlblogUser blblogUser = baseMapper.selectOne(queryWrapper);
//        return blblogUser;
//    }
}
