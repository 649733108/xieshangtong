package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tencent.wxcloudrun.dao.EmissionFactorMapper;
import com.tencent.wxcloudrun.dto.EmissionFactorDto;
import com.tencent.wxcloudrun.model.EmissionFactor;
import com.tencent.wxcloudrun.service.EmissionFactorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    @Autowired
    private EmissionFactorMapper emissionFactorMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<EmissionFactor> getEmissionFactorListByCategory(String category) {
        QueryWrapper<EmissionFactor> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isBlank(category)) {
            queryWrapper.eq("category", category);
        }
        return emissionFactorMapper.selectList(queryWrapper);
    }

    @Override
    public void modifyEmissionFactor(EmissionFactorDto emissionFactorDto) {
        EmissionFactor emissionFactor = emissionFactorMapper.selectById(emissionFactorDto.getId());
        if (emissionFactor == null) {
            throw new RuntimeException("排放因子不存在");
        }
        BeanUtils.copyProperties(emissionFactorDto,emissionFactor);
        emissionFactorMapper.updateById(emissionFactor);
    }
}
