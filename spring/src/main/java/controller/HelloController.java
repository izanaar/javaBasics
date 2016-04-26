package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public void sayHello(HttpServletResponse response) {
        try {
            response.getOutputStream().write("Hi there.".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
