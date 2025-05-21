package kr.ac.kopo.su.bookmarket.Controller;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import kr.ac.kopo.su.bookmarket.domain.Book;
import kr.ac.kopo.su.bookmarket.service.BookService;
import kr.ac.kopo.su.bookmarket.validator.BookValidator;
import kr.ac.kopo.su.bookmarket.validator.UnitsInStockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/books")
public class BookController
{

    @Autowired
    private BookService bookService;

    @Value("${file.uploadDir}")
    private String fileDir;

//    @Autowired
//    private UnitsInStockValidator unitsInStockValidator;
    @Autowired
    private BookValidator bookValidator;

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

    @GetMapping ("/filter/{bookFilter}")
    public String requestByFilter(@MatrixVariable(pathVar = "bookFilter")Map<String, List<String>> bookFilter, Model model)
    {
        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);
        return "books";
    }

    @GetMapping("/add")
    public String requestAddBookForm(Model model)
    {
        model.addAttribute("book", new Book());
        return "addBook";
    }
    @PostMapping("/add")
    public String requestSubmitNewBook(@Valid @ModelAttribute("book") Book book, BindingResult bindResult)
    {

        if(bindResult.hasErrors())
        {
            return "addBook";
        }

        MultipartFile bookImage = book.getBookImage();
        String saveName = bookImage.getOriginalFilename();
        File saveFile = new File(fileDir + saveName);

        if (bookImage != null && !bookImage.isEmpty())
        {
            try
            {
                bookImage.transferTo(saveFile);
            }
            catch (IOException e)
            {
                throw new RuntimeException("이미지 업로드가 안됨.");
            }
        }
        book.setFileName(saveName);
        bookService.setNewBook(book);
        return "redirect:/books";
    }
     @ModelAttribute
    public void addAttribute(Model model)
    {
        model.addAttribute("addTitle", "신규 도서 등록");
    }

    @GetMapping("/download")
    public void downloadBookImage(@RequestParam("file") String paramKey,
                                  HttpServletResponse response) throws IOException {
        File imageFile = new File(fileDir  + paramKey);
        response.setContentType("application/download");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + paramKey + "\"");
        // \
        response.setContentLength((int) imageFile.length());

        OutputStream os = response.getOutputStream();

        // 똑같은 이미지를 다운로드 하게 하려면?
        FileInputStream fis = new FileInputStream(imageFile);
        FileCopyUtils.copy(fis, os);
        fis.close();
        os.close();

    }

    @InitBinder
    public void initBinder (WebDataBinder binder)
    {
        //binder.setValidator(unitsInStockValidator);
        binder.setValidator(bookValidator);
        binder.setAllowedFields("bookId", "name", "unitPrice",
                                "author", "publisher", "description",
                                "category","unitsInStock","releaseDate",
                                "condition", "bookImage");
    }

}
