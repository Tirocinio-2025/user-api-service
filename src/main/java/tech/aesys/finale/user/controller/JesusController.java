package tech.aesys.finale.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jesus")
public class JesusController {

    @RequestMapping("/walksonwater")
    public String walkOnWater() {
        return "Walking on water!";
    }

}
