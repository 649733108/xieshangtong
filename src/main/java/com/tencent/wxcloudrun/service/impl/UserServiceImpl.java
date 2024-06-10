package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.CountersMapper;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.CounterService;
import com.tencent.wxcloudrun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper userMapper;


  @Override
  public void login(String username, String password) {
    User user = userMapper.getUserByUsername(username);
    if (user == null) {
      throw new RuntimeException("该用户不存在");
    }
    if (!user.getPassword().equals(password)) {
      throw new RuntimeException("密码错误");
    }
    log.info("登录成功");
  }
}
