package kr.ac.kopo.su.bookmarket.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.su.bookmarket.domain.Member;
import kr.ac.kopo.su.bookmarket.domain.Role;
import kr.ac.kopo.su.bookmarket.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/loginfailed")
    public String loginFailed(Model model)
    {
        model.addAttribute("error", true);
        return "login";
    }
//    @GetMapping("/logout")
//    public String logout()
//    {
//        return "login";
//    }
    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "login";
    }

//    @Bean
//    public CommandLineRunner run(MemberService memberService) throws Exception {
//        return (String[] args) -> {
//            Member member = new Member();
//
//            member.setMemberId("Admin");
//            member.setName("관리자");
//            member.setPhone("");
//            member.setEmail("");
//            member.setAddress("");
//            String password = new BCryptPasswordEncoder().encode("Admin1234");
//            member.setPassword(password);
//            member.setRole(Role.ADMIN);
//
//            memberService.saveMember(member);
//
//        };
//    }
}
