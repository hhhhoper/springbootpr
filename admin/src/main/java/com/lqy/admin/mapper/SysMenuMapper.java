package com.lqy.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqy.admin.entity.SysMenu;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
    
@Select("""
        SELECT m.*FROM
        sys_menu m JOIN
        sys_role_menu rm ON m.id=
        rm.menu_id where rm.role_id=#{roleId}
        """)
        List<SysMenu> selectMenusByRoleId(Long roleId);

}
