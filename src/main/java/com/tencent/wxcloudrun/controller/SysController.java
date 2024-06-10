package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.LoginDto;
import com.tencent.wxcloudrun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * counter控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/sys")
public class SysController {

	@Autowired
	private UserService userService;


	/**
	 * 获取当前计数
	 *
	 * @return API response json
	 */
	@PostMapping(value = "/login")
	ApiResponse login(@RequestBody LoginDto loginDto) {
		if (StringUtils.isBlank(loginDto.getUsername())) {
			return ApiResponse.error("用户名为空");
		}
		try {
			userService.login(loginDto.getUsername(), loginDto.getPassword());
			return ApiResponse.ok();
		} catch (Exception e) {
			return ApiResponse.error(e.getMessage());
		}
	}
}