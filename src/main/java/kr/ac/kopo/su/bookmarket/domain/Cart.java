package kr.ac.kopo.su.bookmarket.domain;


import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class Cart
{
    private String cartId;
    private Map<String,CartItem > cartItems;
    private BigDecimal grandTotal;

    public Cart()
    {
        cartItems = new HashMap<String,CartItem>();
        grandTotal = new BigDecimal(0);
    }

    public Cart(String cartId)
    {
        this();
        this.cartId = cartId;
    }

    // 전체 주문 총액을 업데이트 하는 메소드
    public void updateGrandTotal()
    {
        grandTotal = new BigDecimal(0);
        for(CartItem cartItem : cartItems.values())
        {
            grandTotal = grandTotal.add(cartItem.getTotalPrice());
        }
    }

    public void addCartItem(CartItem item)
    {
        String bookId = item.getBook().getBookId();
        if (cartItems.containsKey(bookId))
        {
            CartItem cartItem = cartItems.get(bookId);
            cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
            cartItems.put(bookId, cartItem);
        }
        else
        {
            cartItems.put(bookId, item);
        }
        updateGrandTotal();

    }

    public void removeCartItem(CartItem item)
    {
        String bookId = item.getBook().getBookId();
        cartItems.remove(bookId);
        updateGrandTotal();
    }

}
