package com.ego.service;

import com.ego.pojo.AdminWithBLOBs;
import com.ego.result.BaseResult;

public interface UserServiceI {
    /**
     * 用户注册(添加用户)
     * @param admin
     * @return
     */
    BaseResult logon(AdminWithBLOBs admin);
}
