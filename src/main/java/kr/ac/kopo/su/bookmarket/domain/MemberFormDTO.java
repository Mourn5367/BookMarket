package kr.ac.kopo.su.bookmarket.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDTO
{
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String memberId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 최소 8자리, 최대 16자리 이하로 작성하십시오.")
    private String password;
    
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "연락처는 필수 입력 값입니다.")
    private String phone;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "유효한 이메일 양식으로 입력하십시오.")
    private String email;

    @NotBlank(message = "주소는 필수 입력 값입니다.")
    private String address;
}
