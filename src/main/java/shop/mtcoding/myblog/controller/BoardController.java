package shop.mtcoding.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
    
    @GetMapping("/board/{id}")
    public String joinForm(@PathVariable int id) {

        return "board/detail";
    }

    @GetMapping({"/", "/board"})
    public String list() {

        return "board/main";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {

        return "board/saveForm";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id) {

        return "board/updateForm";
    }
}
