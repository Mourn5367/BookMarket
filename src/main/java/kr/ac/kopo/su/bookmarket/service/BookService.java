package kr.ac.kopo.su.bookmarket.service;

import kr.ac.kopo.su.bookmarket.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService
{
    List<Book> getAllBookList();
}
