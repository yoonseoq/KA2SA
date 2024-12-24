package com.green.ca2sa.menu;

import com.green.ca2sa.common.MyFileUtils;
import com.green.ca2sa.menu.model.*;
import com.green.ca2sa.menu.option.MenuOptionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {
    private final MenuMapper mapper;
    private final MenuOptionMapper optionMapper;
    private final MyFileUtils myFileUtils;


    // ❗❗12월23일 마지막)  Post 다시 하기. mapper.postCategoryInfo(p.getCategory()); 이거 한 후에, categoryId 를 얻어오지 못하고 있음. ❗❗


    @Transactional
    public int postMenuInfo(MultipartFile pic, MenuPostReq p) {

        mapper.postCategoryInfo(p);

        // 사진 null 체크
        if(pic==null){
            return mapper.postMenuInfo(p);
        }

        //메뉴 사진 req 객체에 넣기
        String savedPicName = myFileUtils.makeRandomFileName(pic);
        p.setMenuPic(savedPicName);


        System.out.println(p.getCategoryId());



        int result = mapper.postMenuInfo(p);
        long menuId = p.getMenuId();
        long cafeId=p.getCafeId();

        String middlePath = String.format("cafe/%d/menu/%d",cafeId,menuId); // 폴더 위치 수정했음
        myFileUtils.makeFolders(middlePath);

        String filePath = String.format("%s/%s", middlePath, savedPicName);
        try {
            myFileUtils.transferTo(pic, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MenuGetDto> getMenuInfo(MenuGetReq p) {
        return mapper.getMenuInfo(p);
    }

    @Transactional
    public int updateMenuInfo(MultipartFile pic, MenuPutReq p) {
        return mapper.updateMenuInfo(p);
    }

    @Transactional
    public int deleteMenuInfo(MenuDelReq p) {

        int result = optionMapper.deleteMenuOption(p.getMenuId());

        String deletePath = String.format("cafe/%d/menu/%d",p.getCafeId(), p.getMenuId());
        myFileUtils.deleteFolder(deletePath, true);

        return mapper.deleteMenuInfo(p);
    }

    @Transactional
    public List<MenuDetailGetRes> getMenuDetailInfo(MenuDetailGetReq p) {
        List<MenuDetailGetRes> res= mapper.getMenuDetailInfo(p);

        return res;
    }





}