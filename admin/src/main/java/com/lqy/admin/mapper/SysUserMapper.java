package com.lqy.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lqy.admin.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> 
{    
    SysUser selectByUsername(String username);

}