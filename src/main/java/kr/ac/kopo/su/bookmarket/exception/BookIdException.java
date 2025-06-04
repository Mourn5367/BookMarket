package kr.ac.kopo.su.bookmarket.exception;

import lombok.Data;

@Data
public class BookIdException  extends RuntimeException
{

    private String BookId;
    public BookIdException(String BookId)
    {
        super();
        this.BookId = BookId;
    }

}
