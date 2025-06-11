package kr.ac.kopo.su.bookmarket.repository;

import kr.ac.kopo.su.bookmarket.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class CartRepositoryImpl implements CartRepository
{

    private Map<String, Cart> listOfCarts;

    public CartRepositoryImpl()
    {
        listOfCarts = new HashMap<String, Cart>();
    }

    @Override
    public Cart create(Cart cart) {

        if (listOfCarts.containsKey(cart.getCartId()))
        {
            throw new IllegalArgumentException("장비구니를 새로 새로 생성할 수 없음"+ " 현재 장바구니 ID: " + cart.getCartId());
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return null;
    }
}
