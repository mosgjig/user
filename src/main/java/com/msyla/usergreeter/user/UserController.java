package com.msyla.usergreeter.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping("/")
    @ResponseBody
    String get() {
        return "{\"message\":\"Hello World!\"}";
    }
}
