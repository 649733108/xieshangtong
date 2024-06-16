package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.UserVO;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.User;

import java.util.Optional;

public interface UserService {

  UserVO login(String username, String password);
}
