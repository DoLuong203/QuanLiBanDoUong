package cuongxinhdai.java5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BanHangController {
    @GetMapping("Ban_hang/banhang")
    public String view(){
        return "Ban_hang/banhang";
    }
}
