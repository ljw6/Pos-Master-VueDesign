package snnu.campusmarket.market.Authentication;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;
import snnu.campusmarket.market.Utils.CheckUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
JWT拦截器
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHandler = httpServletRequest.getHeader("Authorization");
        logger.info("---->"+authHandler);
        if (authHandler !=null){
            CheckUtils.tokenParser(authHandler);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
