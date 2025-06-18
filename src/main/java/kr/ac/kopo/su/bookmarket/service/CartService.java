package kr.ac.kopo.su.bookmarket.service;

import kr.ac.kopo.su.bookmarket.domain.Cart;

public interface CartService
{
    Cart create(Cart cart);
    Cart read(String cartId);

    void update(String cartId, Cart cart);
    void delete(String cartId);
}
