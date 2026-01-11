package com.lqy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqy.admin.entity.SysRole;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole>{
    
    @Select("""
        SELECT r.* FROM
        sys_role r JOIN 
        sys_user_role ur ON r.id=
        ur.role_id WHERE ur.user_id=
        #{userId}
            """)
    List<SysRole> selectByUserId(Long userId);

}