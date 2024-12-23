package com.green.ca2sa.menu.option;

import com.green.ca2sa.common.MyFileUtils;
import com.green.ca2sa.menu.option.model.MenuOptionPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MenuOptionService {
    private final MenuOptionMapper mapper;
    private final MyFileUtils myFileUtils;

    public int postMenuOption(MenuOptionPostReq p) {
        int result = mapper.postMenuOption(p);
        p.getMenuOptionId();
        return result;
    }
}