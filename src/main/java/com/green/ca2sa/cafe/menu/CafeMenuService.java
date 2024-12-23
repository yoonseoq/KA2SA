package com.green.ca2sa.cafe.menu;

import com.green.ca2sa.cafe.menu.model.CafeGetMenuReq;
import com.green.ca2sa.cafe.menu.model.CafeGetMenuRes;
import com.green.ca2sa.cafe.menu.model.CafeGetOptionReq;
import com.green.ca2sa.cafe.menu.model.CafeGetOptionRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeMenuService {
    private final CafeMenuMapper cafeMenuMapper;

    public List<CafeGetMenuRes> selCafeMenu(CafeGetMenuReq p){
        List<CafeGetMenuRes> res = cafeMenuMapper.selCafeMenu(p);

        return res;
    }

    public List<CafeGetOptionRes> selCafeMenuOption(CafeGetOptionReq p){
        List<CafeGetOptionRes> res = cafeMenuMapper.selCafeMenuOption(p);

        return res;
    }
}
