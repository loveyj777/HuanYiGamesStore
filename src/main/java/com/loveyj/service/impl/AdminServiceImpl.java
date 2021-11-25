package com.loveyj.service.impl;

import com.loveyj.mapper.AdminMapper;
import com.loveyj.pojo.Admin;
import com.loveyj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: AdminServiceImpl
 * @Description:
 * @author: Lov3YJ
 * @date: 2021/11/22 11:53
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
   private AdminMapper adminMapper;

    @Override
    public Admin findUser(Admin admin) {
        return adminMapper.findAdmin(admin);
    }
}
