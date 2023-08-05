package com.yanxizhu.authority;

import com.yanxizhu.authority.entity.User;
import com.yanxizhu.authority.mappper.UserMapper;
import com.yanxizhu.authority.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class AuthorityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserMapper userMapper;

    /***
     * 测试MybatisPuls是否可用
     */
    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    /**
     * 测试自定义的加密方式
     */
    @Test
    public void BCryptPasswordEncoderTest() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }

    @Test
    public void createJWT(){
        String jwt = JwtUtil.createJWT("1");
        System.out.println(jwt);
    }
    /**
     * Jwt解析
     * @throws Exception
     */
    @Test
    public void parseJWT() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjYWM2ZDVhZi1mNjVlLTQ0MDAtYjcxMi0zYWEwOGIyOTIwYjQiLCJzdWIiOiJzZyIsImlzcyI6InNnIiwiaWF0IjoxNjM4MTA2NzEyLCJleHAiOjE2MzgxMTAzMTJ9.JVsSbkP94wuczb4QryQbAke3ysBDIL5ou8fWsbt_ebg";
        Claims claims = JwtUtil.parseJWT(token);
        System.out.println(claims);
    }
}
