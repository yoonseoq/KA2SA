package com.green.ca2sa.order.orderMenu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("order/menu")
@Slf4j
public class OrderMenuController { //주문내역 확인
    private final OrderMenuService orderMenuService;
}
