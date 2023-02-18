package shop.mtcoding.myblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.myblog.dto.UserReq.JoinReqDto;
import shop.mtcoding.myblog.handler.ex.CustomException;
import shop.mtcoding.myblog.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) {
        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            throw new CustomException("username이 존재하지 않습니다.");
        }

        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new CustomException("password이 존재하지 않습니다.");
        }

        if (joinReqDto.getEmail() == null || joinReqDto.getEmail().isEmpty()) {
            throw new CustomException("email이 존재하지 않습니다.");
        }

        userService.회원가입(joinReqDto);
        
        return "redirect:/loginForm";
    }
    
    @GetMapping("/joinForm")
    public String joinForm() {

        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {

        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {

        return "user/updateForm";
    }
}
