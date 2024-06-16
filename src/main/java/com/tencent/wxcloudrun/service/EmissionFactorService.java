package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.EmissionFactorDto;
import com.tencent.wxcloudrun.model.EmissionFactor;

import java.util.List;

public interface EmissionFactorService {

  List<EmissionFactor> getEmissionFactorListByCategory(String category);

  void modifyEmissionFactor(EmissionFactorDto emissionFactorDto);
}
