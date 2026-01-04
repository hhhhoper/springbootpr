package com.lqy.admin.service;

import com.lqy.admin.entity.SysUser;

public interface SysUserService {
    SysUser getByUsername(String username);
    SysUser registerUser(String username, String password);
 }