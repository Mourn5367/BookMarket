package kr.ac.kopo.su.bookmarket.Controller;


import kr.ac.kopo.su.bookmarket.domain.Book;
import kr.ac.kopo.su.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "books")
public class BookController
{

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ModelAndView requestAllBookList()
    {
        ModelAndView modelV = new ModelAndView();
        modelV.setViewName("books");
        List<Book> bookList = bookService.getAllBookList();
        modelV.addObject("bookList", bookList);

        return modelV;

    }
    @GetMapping()
    public String requestBookList(Model model)
    {
        List<Book> bookList = bookService.getAllBookList();
        model.addAttribute("bookList", bookList);
        return "books";
        // 리턴값은 HTML의 파일이름과 동일해야함.
    }


    @GetMapping("/book")
    public String requestBookById(Model model, @RequestParam("id") String bookId)
    {
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category")String category, Model model)
    {
        List<Book> booksByCategory = bookService.getBookListByCategory(category);
        // "bookList" 이거 기존거랑 같게 해야함. 주소가 같음.
        model.addAttribute("bookList", booksByCategory);
        return "books";
    }

}
