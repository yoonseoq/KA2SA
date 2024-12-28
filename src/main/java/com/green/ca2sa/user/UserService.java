package com.green.ca2sa.user;

import com.green.ca2sa.user.model.*;
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

   public int postUserSignUp(UserSignUpReq p) {

       String hashedPassword = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
       p.setUpw(hashedPassword);

       return mapper.postUserSignUp(p);
   }

   public int getEmailCheck(String email) {
       UserSignUpEmailCheckRes res = mapper.getUserEmailCheck(email);
       if (res == null){
           return 1;
       }
       return 0;
   }

   public UserSignInRes postUserSignIn(UserSignInReq p) {
       UserSignInRes res = mapper.postUserSingIn(p);
       if (res == null){
           res = new UserSignInRes();
           res.setMessage("이메일을 확인하세요");

           return res;
       } else if (res.getUpw() == null) {
           res = new UserSignInRes();
           res.setMessage("비밀번호를 확인하세요");

           return res;
       }
       return res;
   }

   public UserInfoGetRes getUserInfo(long userId) {
       UserInfoGetRes res = mapper.getUserInfo(userId);

       return res;
   }

   public int updateUserInfo(UserInfoPutReq p){

       UserInfoPutDto dto = mapper.updateCheckUpwInfo(p);

       if (!BCrypt.checkpw(p.getUpw(),dto.getUpw())){
           return 0; // 빠꾸먹으면 0으로 전환
       }


       int result = mapper.updateUserInfo(p);

       return result;
   }

   public int deleteUserInfo(long userId) {
       int result = mapper.deleteUserInfo(userId);
       return result;
   }

}
