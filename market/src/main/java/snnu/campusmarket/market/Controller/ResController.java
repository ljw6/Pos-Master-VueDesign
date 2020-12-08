package snnu.campusmarket.market.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import snnu.campusmarket.market.Dao.GoodsDao;
import snnu.campusmarket.market.Entity.Goods;
import snnu.campusmarket.market.Entity.JwtRequest;
import snnu.campusmarket.market.Entity.JwtResponse;
import snnu.campusmarket.market.Entity.Users;
import snnu.campusmarket.market.Utils.CheckUtils;
import snnu.campusmarket.market.service.JwtUserDetailsService;
import snnu.campusmarket.market.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
public class ResController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private CheckUtils utils;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @PostMapping("${jwt.route.authentication.path}")
    public ResponseEntity<?> createAuthenticationToken(JwtRequest request) throws Exception {
        System.out.println("username:"+request.getUsername()+"password:"+request.getPassword());
        authenticate(request.getUsername(),request.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = utils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String name, String pass) throws Exception {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(name,pass));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED",e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }
    }

    @Autowired
    UserService userService;

    @GetMapping("/token")
    public Users getAuthenticatedUser(HttpServletRequest request){
        String token = request.getHeader(tokenHeader).substring(7);
        String username= utils.getUsernameFromToken(token);
        User userdetials = (User) userDetailsService.loadUserByUsername(username);
        return userService.getUserFromUserDetails(userdetials);
    }

    @GetMapping("/last_list")
    public List<Goods> getLastGoods(){

        List<Goods> last_list =  goodsDao.selectList(null);

        System.out.println(last_list);
        return last_list;
    }
}
