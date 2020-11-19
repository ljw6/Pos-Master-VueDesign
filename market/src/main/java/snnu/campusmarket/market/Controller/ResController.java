package snnu.campusmarket.market.Controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ResController {

    @GetMapping("/hello")
    public String main(){
        return "hello";
    }

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }

    @GetMapping("/needAdminRole")
    public String needAdmin(){
        return "Admin";
    }

    @GetMapping("/needUserRole")
    public String UserRole(){
        return "User";
    }

    @RequestMapping("/loginInfo")
    public String loginInfo(){
        return "Please Log in";
    }

    @RequestMapping("/logoutSuccess")
    public String logoutSuccess(){
        return "Log out";
    }
}
