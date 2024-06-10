package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by wxn
 * 2024/6/10 20:09
 */

@Data
public class User {

	private Integer id;
	private String username;
	private String password;
	private Integer isAdmin;
	private Date createTime;
	private Date updateTime;
}
