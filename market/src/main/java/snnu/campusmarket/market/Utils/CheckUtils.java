package snnu.campusmarket.market.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.alibaba.fastjson.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CheckUtils implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    public String getUsernameFromToken(String token){
        return getClaimFromToken(token,Claims::getSubject);
    }

    /*
    token 超时处理
     */
    public Date getExpirationFromToken(String token){
        return getClaimFromToken(token,Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsTFunction){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsTFunction.apply(claims);
    }

    private Claims getAllClaimsFromToken (String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /*
    判断超时
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return doGenerateToken(claims,userDetails.getUsername());
    }

    private String doGenerateToken(Map<String,Object> claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512,secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
//    private static Logger logger =LoggerFactory.getLogger(CheckUtils.class);
//    private static HashMap<String, Authentication> hashMap = new HashMap<>();
//
//    /*
//    生成Token
//     */
//
//    public static String generateToken(Authentication authentication){
//        hashMap.put("authentication",authentication);
//        String token = Jwts.builder()
//                //设置token的信息
//                //将认证后的authentication写入token，验证时，直接验证它
//                .claim("authentication",authentication)
//                //设置主题
//                .setSubject("主题")
//                //过期时间
//                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
//                //加密方式及秘钥
//                .signWith(SignatureAlgorithm.HS512, "MyJWTtest")
//                .compact();
//
//        return token;
//    }
    /*
    Token解析
     */
//    public static void tokenParser(String token){
//        Authentication authentication1 = hashMap.get("authentication");
//        System.out.println(authentication1);
//        // 解析token.
//        Claims claims = Jwts.parser()
//                .setSigningKey("MyJWTtest")
//                .parseClaimsJws(token)
//                .getBody();
//
////            获取suject
////            String subject = claims.getSubject();
////            User user = (User) claims.get("user");
//        //获取过期时间
//        Date claimsExpiration = claims.getExpiration();
//        logger.info("过期时间"+claimsExpiration);
//        //判断是否过期
//        Date now = new Date();
//        if (now.getTime() > claimsExpiration.getTime()) {
//            throw new AuthenticationServiceException("凭证已过期，请重新登录！");
//        }
//        //获取保存在token中的登录认证成功的authentication，
//        // 利用UsernamePasswordAuthenticationToken生成新的authentication
//        // 放入到SecurityContextHolder，表示认证通过
//        Object tokenInfo = claims.get("authentication");
//        //通过com.alibaba.fastjson将其在转换。
//        JsonToAuthtication toknAuthentication = JSONObject.parseObject(JSONObject.toJSONString(tokenInfo), JsonToAuthtication.class);
////        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(toknAuthentication.getPrincipal(),null,toknAuthentication.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(toknAuthentication);
//    }

}
