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
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {
    private final MenuMapper mapper;
    private final MenuOptionMapper optionMapper;
    private final MyFileUtils myFileUtils;

    @Transactional
    public int postMenuInfo(MultipartFile pic, MenuPostReq p) {
        mapper.postMenuCategoryInfo(p);

        // 사진 null 체크
        if (pic == null) {
            return mapper.postMenuInfo(p);
        }

        //메뉴 사진 req 객체에 넣기
        String savedPicName = myFileUtils.makeRandomFileName(pic);
        p.setMenuPic(savedPicName);


        int result = mapper.postMenuInfo(p);
        long menuId = p.getMenuId();
        long cafeId=p.getCafeId();

        String middlePath = String.format("cafe/%d/menu/%d",cafeId,menuId); // 폴더 위치 수정했음
        myFileUtils.makeFolders(middlePath);

        String filePath = String.format("%s/%s", middlePath, savedPicName);
        try {
            myFileUtils.transferTo(pic, filePath);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    public List<MenuGetDto> getMenuInfo(MenuGetReq p) {
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
            log.error(e.getMessage());
        }
        return result;
    }

    @Transactional
    public int deleteMenuInfo(MenuDelReq p) {

        optionMapper.deleteMenuOption(p.getMenuId());

        String deletePath = String.format("cafe/%d/menu/%d", p.getCafeId(), p.getMenuId());
        myFileUtils.deleteFolder(deletePath, true);

        return mapper.deleteMenuInfo(p);
    }

    @Transactional
    public List<MenuDetailGetRes> getMenuDetailInfo(MenuDetailGetReq p) {

        return mapper.getMenuDetailInfo(p);
    }


}