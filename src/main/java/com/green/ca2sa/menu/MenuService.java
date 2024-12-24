package com.green.ca2sa.menu;

import com.green.ca2sa.common.MyFileUtils;
import com.green.ca2sa.menu.model.*;
import com.green.ca2sa.menu.option.MenuOptionMapper;
import com.green.ca2sa.menu.option.model.MenuOptionPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuMapper mapper;
    private final MenuOptionMapper optionMapper;
    private final MyFileUtils myFileUtils;

    @Transactional
    public int postMenuInfo(MultipartFile pic, MenuPostReq p) {

        // 사진 null 체크
        if(pic==null){
            return mapper.postMenuInfo(p);
        }

        //메뉴 사진 req 객체에 넣기
        String savedPicName = myFileUtils.makeRandomFileName(pic);
        p.setMenuPic(savedPicName);


        int result = mapper.postMenuInfo(p);
        long menuId = p.getMenuId();

        String middlePath = String.format("/menu/%d", menuId);
        myFileUtils.makeFolders(middlePath);

        String filePath = String.format("%s/%s", middlePath, savedPicName);
        try {
            myFileUtils.transferTo(pic, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MenuGetRes> getMenuInfo(MenuGetReq p) {
        return mapper.getMenuInfo(p);
    }

    @Transactional
    public int updateMenuInfo(MultipartFile pic, MenuPutReq p) {
        if (pic == null) {
            return mapper.updateMenuInfo(p);
        }
        String deletePath = String.format("/menu/%d", p.getCafeId());
        myFileUtils.deleteFolder(deletePath, true);

        String savedPicName = myFileUtils.makeRandomFileName(pic);
        p.setMenuPic(savedPicName);

        int result = mapper.updateMenuInfo(p);

        long menuId = p.getMenuId();
        String middlePath = String.format("/menu/%d", menuId);
        myFileUtils.makeFolders(middlePath);

        String filePath = String.format("%s/%s", middlePath, savedPicName);
        try {
            myFileUtils.transferTo(pic, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional
    public int deleteMenuInfo(MenuDelReq p) {

        int result = optionMapper.deleteMenuOption(p.getMenuId());

        String deletePath = String.format("%s/menu/%d", myFileUtils.getUploadPath(), p.getMenuId());
        myFileUtils.deleteFolder(deletePath, true);

        return mapper.deleteMenuInfo(p);


    }

    @Transactional
    public List<MenuDetailGetRes> getMenuDetailInfo(MenuDetailGetReq p) {
        List<MenuDetailGetRes> res = mapper.getMenuDetailInfo(p);
        return res;
    }
}