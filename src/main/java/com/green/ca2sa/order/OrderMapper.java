package com.green.ca2sa.order;

import com.green.ca2sa.order.model.OrderGetReq;
import com.green.ca2sa.order.model.OrderGetRes;
import com.green.ca2sa.order.model.OrderPostReq;
import com.green.ca2sa.order.orderMenu.model.OrderMenuGetDto;
import com.green.ca2sa.order.orderMenu.model.OrderMenuOptionGetDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int insOrder(OrderPostReq p);
    List<OrderGetRes> getOrderList(OrderGetReq p); // 오더리스트 불러오고
    List<OrderMenuGetDto> getOrderMenu(long orderId); // 그 오더 아이디로 주문한 메뉴들 불러오고
    List<OrderMenuOptionGetDto> selOrderMenuOption(long orderMenuId); //각 메뉴들마다 옵션 불러오기

}
