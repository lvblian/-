package com.blblog.label.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blblog.label.mapper.BlblogLabelMapper;
import com.blblog.label.service.BlblogLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dto.BlblogDto;
import entity.BlblogLabel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author lbl
 * @since 2020-01-18
 */
@Service
public class BlblogLabelServiceImpl extends ServiceImpl<BlblogLabelMapper, BlblogLabel> implements BlblogLabelService {

    @Override
    public IPage<BlblogLabel> pageQuery(Page<BlblogLabel> labelPage, BlblogDto blblogDto) {
        //获取查询条件
        String labelname = blblogDto.getLabelname();
        Long fans = blblogDto.getFans();
        Date createtime = blblogDto.getCreatetime();
        Date updatetime = blblogDto.getUpdatetime();
        QueryWrapper<BlblogLabel> queryWrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(labelname) || !StringUtils.isEmpty(fans)) {
//            queryWrapper.like("labelname",labelname);
            queryWrapper.and(i -> i.like("labelname", labelname)
                                    .or()
                                    .like("fans", fans)
            );
        }
        IPage<BlblogLabel> labelIPage = baseMapper.selectPage(labelPage, queryWrapper);
        return labelIPage;
    }
}
