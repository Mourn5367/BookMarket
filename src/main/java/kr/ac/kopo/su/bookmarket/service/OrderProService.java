package kr.ac.kopo.su.bookmarket.service;

import kr.ac.kopo.su.bookmarket.domain.Order;
import kr.ac.kopo.su.bookmarket.repository.OrderProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProService
{

    @Autowired
    private OrderProRepository orderProRepository;

    public void save(Order order)
    {
        orderProRepository.save(order);
    }
}
