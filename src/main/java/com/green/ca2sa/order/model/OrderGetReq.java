package com.green.ca2sa.order.model;

import lombok.Getter;

@Getter

public class OrderGetReq {

}

//orderId
    //userId cafeId 둘다 추가해놓고 integer null 체크해서 null이 아닐떄는 where문
 /*
    <if test="userId != null"> //만약 고객계정이면 이렇게
    where userId = #{userId}
        </if>

    <if test="cafeId != null"> // 카페계졍으로 조회할 시 이렇게
    where cafeId = #{cafeId}
        </if>


  */
