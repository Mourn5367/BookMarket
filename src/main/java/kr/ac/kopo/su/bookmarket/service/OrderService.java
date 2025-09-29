package kr.ac.kopo.su.bookmarket.service;

import kr.ac.kopo.su.bookmarket.domain.Order;

public interface OrderService
{
    // 도서재고 수량 확인
    void confirmOrder(String bookId, long quantity);

    Long saveOrder(Order order);
}
