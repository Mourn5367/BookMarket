package kr.ac.kopo.su.bookmarket.domain;

import jakarta.validation.constraints.*;
import kr.ac.kopo.su.bookmarket.validator.BookId;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

//@Getter
//@Setter
//@NoArgsConstructor
//@Repository
@Data
public class Book
{
    @BookId
    @Pattern(regexp="ISBN_[0-9]+")
    private String bookId; // 도서번호
    @Size(min=4, max=50)
    private String name; // 도서명

    @Min(value = 0)
    @Digits(integer = 8, fraction = 2)
    @NotNull
    private BigDecimal unitPrice; // 단가
    private String author; // 저자
    private String publisher; // 출판사
    private String description; // 도서설명
    private String category; //도서분류
    private long unitsInStock; // 재고량
    private String releaseDate; // 출판일
    private String condition; // 신규도서 또는 중고도서 또는 전자책
    private String fileName; // 도서 이미지 파일 주소
    private MultipartFile bookImage; // "업로드"된 도서 이미지 파일

}
