package com.yanxizhu.authority.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yanxizhu.authority.entity.User;
import com.yanxizhu.authority.mappper.MenuMapper;
import com.yanxizhu.authority.mappper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 实现SpringSecurity的UserDetailsService接口
 * 让SpringSecurity使用我们自己写的
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名，查询用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(wrapper);
        //用户名不存在
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }

        //TODO 根据用户查询权限信息 添加到LoginUser中，先暂时写死
        List<String> permissionKeyList =  menuMapper.selectPermsByUserId(user.getId());
//        //测试写法
        return new LoginUser(user,permissionKeyList);

//        List<String> list = new ArrayList<>(Arrays.asList("test"));
//        //封装成UserDetails对象返回
//        return new LoginUser(user,list);

        //封装成UserDetails对象返回
//        return new LoginUser(user);
    }
}
