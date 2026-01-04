package com.lqy.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lqy.admin.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> 
{    
    @Select("SELECT * FROM sys_user WHERE username = #{username}")
    SysUser selectByUsername(String username);
    

}