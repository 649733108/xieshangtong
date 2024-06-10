package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import com.tencent.wxcloudrun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
   * @return API response json
   */
  @GetMapping(value = "/login")
  ApiResponse login() {
    userService.login("wxn", "wxn");
    return ApiResponse.ok();
  }
  
}