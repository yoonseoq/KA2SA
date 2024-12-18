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
        int res = cafeMapper.insCafe(p);

        //암호화

        return res;
    }
    public int signUpEmailCheck(String email){
            if(cafeMapper.emailCheck(email)==null){
                return 0;
            }
            return 1;
    }
}
