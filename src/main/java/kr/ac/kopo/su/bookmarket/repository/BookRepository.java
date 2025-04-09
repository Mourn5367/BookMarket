package kr.ac.kopo.su.bookmarket.repository;

import kr.ac.kopo.su.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface BookRepository
{
    List<Book> getAllBookList();
    Book getBookById(String bookId);
}
