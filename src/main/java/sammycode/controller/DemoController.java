package sammycode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sammycode.service.DemoService;

@Slf4j
@Controller
public class DemoController {

      //===fields===
    private final DemoService demoService;

//    ==== constructors ====
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

//    ===  request methods ====

    //    http://localhost:8080/TodoList/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //    http://localhost:8080/TodoList/welcome
//        http://localhost:8080/TodoList/welcome?user=Tim

    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model={}", model);

        //    prefix + name + suffix
//    /WEB-INF/view/welcome.jsp
        return "welcome";
    }

//     === model attributes ==

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
