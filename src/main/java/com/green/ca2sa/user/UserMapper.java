package com.green.ca2sa.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(User user);
}
