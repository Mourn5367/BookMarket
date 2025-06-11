package kr.ac.kopo.su.bookmarket.repository;

import kr.ac.kopo.su.bookmarket.domain.Cart;

public interface CartRepository
{
    Cart create(Cart cart);
    Cart read(String cartId);

}
