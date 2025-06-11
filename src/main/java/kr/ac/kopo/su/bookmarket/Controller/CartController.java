package kr.ac.kopo.su.bookmarket.Controller;


import jakarta.servlet.http.HttpServletRequest;
import kr.ac.kopo.su.bookmarket.domain.Cart;
import kr.ac.kopo.su.bookmarket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController
{

    @Autowired
    private CartService cartService;


    @GetMapping
    public String requestCartId(HttpServletRequest request)
    {
        System.out.println("request cart id : " + request.getParameter("cartId"));

        String sessionId = request.getSession().getId();
        return "redirect:/cart/" + sessionId;

    }

    @PostMapping
    public @ResponseBody Cart create(@RequestBody Cart cart)
    {
        System.out.println("create cart : " + cart);
        return cartService.create(cart);
    }

    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model)
    {
        System.out.println("request cart List : " + cartId);
        Cart cart = cartService.read(cartId);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PutMapping("/{cartId}")
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId)
    {
        System.out.println("read cart : " + cartId);
        return cartService.read(cartId);
    }
}
