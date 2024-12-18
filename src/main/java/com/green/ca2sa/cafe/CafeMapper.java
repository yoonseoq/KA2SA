package com.green.ca2sa.cafe;

import com.green.ca2sa.cafe.model.CafeGetRes;
import com.green.ca2sa.cafe.model.CafeOrderPutReq;
import com.green.ca2sa.cafe.model.CafePutReq;
import com.green.ca2sa.cafe.model.CafeSignUpReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMapper {
    int updCafe(CafePutReq p);
    CafeGetRes selCafe(long cafeId);
    int updCafeOrder(CafeOrderPutReq p);
    int insCafe(CafeSignUpReq p);
    Long emailCheck(String email);
}
