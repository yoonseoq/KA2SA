package com.green.ca2sa.cafe;

import com.green.ca2sa.cafe.model.*;
import com.green.ca2sa.common.MyFileUtils;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeMapper cafeMapper;
    private final MyFileUtils myFileUtils;

    // 카페 회원 가입
    public int signUpCafe(MultipartFile pic, CafeSignUpReq p){
        String fileName = pic != null ? myFileUtils.makeRandomFileName(pic) : null;
        String hasPwd = BCrypt.hashpw(p.getApw(), BCrypt.gensalt());
        p.setApw(hasPwd);
        p.setCafePic(fileName);
        int res = cafeMapper.insCafe(p);
        long cafeId = p.getCafeId();
        String folderPath = String.format("cafe/%d", cafeId);
        myFileUtils.makeFolders(folderPath);
        if(pic == null){
            return res;
        }
        String filePath = String.format("%s/%s",folderPath,fileName);
        try {
            myFileUtils.transferTo(pic,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    // 카페 로그인
    public CafeSignInRes signInCafe(CafeSignInReq p){
        String email = p.getEmail();
        CafeSignInRes res = cafeMapper.signInCafe(email);
        if(res == null){
            res = new CafeSignInRes();
            res.setMsg("이메일이 다릅니다.");
            return res;
        }
        if(!BCrypt.checkpw(p.getApw(), res.getApw())){
            res = new CafeSignInRes();
            res.setMsg("비밀번호가 다릅니다.");
            return res;
        }
        res.setMsg("로그인 성공");
        return res;
    }


    // 카페 정보 변경
    public int updCafe(CafePutReq p){
        int result = cafeMapper.updCafe(p);
        return result;
    }

    // 카페 주문상태 변경
    public int updCafeOrder(CafeOrderPutReq p){
        return cafeMapper.updCafeOrder(p);
    }

    // 카페 조회
    public CafeGetRes selCafe(CafeGetReq p){
        long cafeId= p.getCafeId();
        CafeGetRes res = cafeMapper.selCafe(cafeId);
        return res;
    }

    // 카페 이메일 중복확인
    public int signUpEmailCheck(CafeCheckEmailPostReq p){
        if(cafeMapper.cafeEmailCheck(p.getEmail())==null){
            return 1;
        }
        return 0;
    }

    public CafeGetWeekRes selCafeSales(CafeGetWeekReq p){
        List<CafeGetWeekDto> cafeGetWeekDtoList = cafeMapper.selSumPriceWeekOfDay(p);
        int weekSum = 0;
        for(CafeGetWeekDto c : cafeGetWeekDtoList){
            weekSum += c.getDaySumPrice();
        }
        CafeGetWeekRes res = new CafeGetWeekRes();
        res.setWeekSumPrice(weekSum);
        res.setSelWeek(cafeGetWeekDtoList);
        return res;
    }

}
