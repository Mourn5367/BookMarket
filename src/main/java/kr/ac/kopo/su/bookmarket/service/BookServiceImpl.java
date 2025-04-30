package kr.ac.kopo.su.bookmarket.service;

import kr.ac.kopo.su.bookmarket.domain.Book;
import kr.ac.kopo.su.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService
{

    // 이거 쓰면 알아서 찾아줌
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }

    @Override
    public Book getBookById(String bookId)
    {
        Book bookInfo = bookRepository.getBookById(bookId);
        return bookInfo;
    }

    @Override
    public List<Book> getBookListByCategory(String category)
    {
        List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter)
    {
        Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
        return booksByFilter;
    }

}
