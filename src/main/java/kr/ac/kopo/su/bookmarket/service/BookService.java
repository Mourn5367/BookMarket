package kr.ac.kopo.su.bookmarket.service;

import kr.ac.kopo.su.bookmarket.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface BookService
{
    List<Book> getAllBookList();
    Book getBookById(String id);
    List<Book> getBookListByCategory(String category);
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter);
}
