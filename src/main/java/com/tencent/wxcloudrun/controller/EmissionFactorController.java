package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.EmissionFactorDto;
import com.tencent.wxcloudrun.dto.LoginDto;
import com.tencent.wxcloudrun.service.EmissionFactorService;
import com.tencent.wxcloudrun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/emissionFactor")
public class EmissionFactorController {

	@Autowired
	private EmissionFactorService emissionFactorService;


	/**
	 * 获取排放因子列表
	 * @param category
	 * @return
	 */
	@GetMapping(value = "/emissionFactorListByCategory")
	ApiResponse getEmissionFactorListByCategory(@RequestParam(required = false) String category) {
		log.info("========getEmissionFactorListByCategory========");
		log.info("category=" + category);
		return ApiResponse.ok(emissionFactorService.getEmissionFactorListByCategory(category));
	}

	/**
	 * 更新排放因子
	 */
	@PostMapping("/modify")
	ApiResponse modifyEmissionFactor(@RequestBody EmissionFactorDto emissionFactorDto) {
		emissionFactorService.modifyEmissionFactor(emissionFactorDto);
		return ApiResponse.ok();
	}

}