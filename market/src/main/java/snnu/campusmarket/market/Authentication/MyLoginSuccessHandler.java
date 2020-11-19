package snnu.campusmarket.market.Authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import snnu.campusmarket.market.Utils.CheckUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component("myLoginSuccessHandler")
public class MyLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
//        response.setStatus(200);
        logger.info("登录成功");
        /*
        登录成功后的Token
        并将Authorization以json的形式返回到前端
         */
        String token = CheckUtils.generateToken(authentication);
        response.addHeader("Authorization",token);
        /*
        设置返回类型
         */
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> tokenInfo = new HashMap<String, Object>();
        tokenInfo.put("Authorization",token);
        /*
        写入Token
         */
        response.getWriter().write(objectMapper.writeValueAsString(tokenInfo));
    }
}
