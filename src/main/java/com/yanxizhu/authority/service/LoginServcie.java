package com.yanxizhu.authority.service;

import com.yanxizhu.authority.entity.User;
import com.yanxizhu.authority.common.ResponseResult;

/**
 * 用户登录接口
 */
public interface LoginServcie {
    /**
     * 登录接口
     * @param user
     * @return
     */
    public ResponseResult login(User user);

    ResponseResult logout();
}
