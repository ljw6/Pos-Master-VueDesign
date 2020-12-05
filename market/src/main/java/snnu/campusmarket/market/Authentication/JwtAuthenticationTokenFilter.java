package snnu.campusmarket.market.Authentication;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import snnu.campusmarket.market.Utils.CheckUtils;
import snnu.campusmarket.market.service.JwtUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
JWT拦截器
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private CheckUtils utils;

    @Value("${jwt.route.authentication.path}")
    private String path;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String username=null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = utils.getUsernameFromToken(jwtToken);
            }catch (IllegalArgumentException e){
                System.out.println("无法获取Token");
            }catch (ExpiredJwtException e){
                System.out.println("Token 已过期");
            }
        }else {
            logger.warn("Token 是非法开头");
        }

        if (username !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails details = this.userDetailsService.loadUserByUsername(username);
            if (utils.validateToken(jwtToken,details)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(details,null,details.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
