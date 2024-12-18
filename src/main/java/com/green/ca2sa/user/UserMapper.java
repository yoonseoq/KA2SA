package com.green.ca2sa.user;

import com.green.ca2sa.user.model.UserSignUpEmailCheckRes;
import com.green.ca2sa.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(UserSignUpReq p);
    UserSignUpEmailCheckRes getUserEmailCheck(String email);
}
