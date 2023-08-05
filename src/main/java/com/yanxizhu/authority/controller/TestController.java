package com.yanxizhu.authority.controller;

import com.yanxizhu.authority.common.ResponseResult;
import com.yanxizhu.authority.mappper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TestController {

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/hi")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public String hi() {
        String uuid = UUID.randomUUID().toString();
        return "Hi:" + uuid;
    }

    @GetMapping("/menus")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult menuList() {
        List<String> strings = menuMapper.selectPermsByUserId(3L);
        return new ResponseResult(200, "获取菜单成功",strings);
    }
}
