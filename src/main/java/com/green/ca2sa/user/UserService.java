package com.green.ca2sa.user;

import com.green.ca2sa.user.model.UserSignUpEmailCheckRes;
import com.green.ca2sa.user.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserMapper mapper;

    public int postUser(UserSignUpReq p){

        String hashPassword= BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());

        p.setUpw(hashPassword);

        int result=mapper.postUser(p);

        return result;
    }

    public int getUserEmailCheck(String email){
        UserSignUpEmailCheckRes res=mapper.getUserEmailCheck(email);

        if(res==null){
            return 1;
        }

        return 0;

    }
}
