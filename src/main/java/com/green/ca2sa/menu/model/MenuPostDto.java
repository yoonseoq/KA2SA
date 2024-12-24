package com.green.ca2sa.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuPostDto {
    @Schema(title = "카테고리", example = "커피", description = "아무것도 입력안할시 '기타'로 등록")
   private String category;

    @JsonIgnore
    private long categoryId;
}
