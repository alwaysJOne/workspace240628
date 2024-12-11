package study.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy 요청 성공");
        return "ok";
    }
}
