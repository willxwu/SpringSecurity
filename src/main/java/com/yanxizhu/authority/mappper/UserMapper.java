package com.yanxizhu.authority.mappper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanxizhu.authority.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
