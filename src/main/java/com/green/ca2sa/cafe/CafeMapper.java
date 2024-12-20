package com.green.ca2sa.cafe;

import com.green.ca2sa.cafe.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMapper {
    int updCafe(CafePutReq p);
    int updCafeOrder(CafeOrderPutReq p);
    CafeGetRes selCafe(long cafeId);
    String cafeEmailCheck(String email);
    int insCafe(CafeSignUpReq p);
    CafeSignInRes signInCafe(String email);
}
