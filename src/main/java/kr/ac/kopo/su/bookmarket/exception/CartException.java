package kr.ac.kopo.su.bookmarket.exception;

import lombok.Getter;

@Getter
public class CartException extends RuntimeException{

    private String cartId;

    public CartException (String cartId)
    {
        this.cartId = cartId;
    }

}
