package kr.ac.kopo.su.bookmarket.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 카테고리 에러 발 생 시
@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryException extends RuntimeException
{
    private String errorMessage;
    private String category;
    public CategoryException(String category)
    {
        super();
        errorMessage = "요청한 도서 분야를 찾을 수 없습니다.";
        System.out.println(errorMessage);
        this.category = category;
    }


}
