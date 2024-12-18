package com.green.ca2sa.cafe;

import com.green.ca2sa.cafe.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeMapper cafeMapper;

    public int updCafe(CafePutReq p){
        int result = cafeMapper.updCafe(p);
        return result;
    }

    public CafeGetRes selCafe(CafeGetReq p){
        long cafeId= p.getCafeId();
        CafeGetRes res = cafeMapper.selCafe(cafeId);
        return res;
    }

    public int updCafeOrder(CafeOrderPutReq p){
        return cafeMapper.updCafeOrder(p);
    }

    public int signUpCafe(CafeSignUpReq p){
//        if(cafeMapper.emailCheck(p.getEmail())==null){
//            p.setMsg("중복된 이메일 입니다.");
//            return 0;
//        } 쳐피 email 인증부터면 필요가 없는거아님?

        int res = cafeMapper.insCafe(p);

        //암호화

        return res;
    }
}
