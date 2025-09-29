package kr.ac.kopo.su.bookmarket.repository;


import kr.ac.kopo.su.bookmarket.domain.Order;

public interface OrderRepository
{
    //주문 목록 저장
    Long saveOrder(Order order);
}
