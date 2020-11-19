package snnu.campusmarket.market.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import snnu.campusmarket.market.Authentication.JwtAuthenticationTokenFilter;
import snnu.campusmarket.market.Authentication.MyLoginFailureHandler;
import snnu.campusmarket.market.Authentication.MyLoginSuccessHandler;
import snnu.campusmarket.market.Utils.MyAccessDeniedHandler;
import snnu.campusmarket.market.service.UserLoginService;

@Configuration
public class MySecuConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyLoginSuccessHandler myLoginSuccessHandler;

    @Autowired
    private MyLoginFailureHandler myLoginFailureHandler;

    @Autowired
    private MyAccessDeniedHandler handler;

    @Autowired
    private UserLoginService userLoginService;

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userLoginService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置拦截器
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter =new JwtAuthenticationTokenFilter();
        //添加拦截器到验证之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        http.formLogin()
                .loginPage("/loginInfo")
                .loginProcessingUrl("/login")
                .successHandler(myLoginSuccessHandler)
                .failureHandler(myLoginFailureHandler);
        http.authorizeRequests()
                .antMatchers("/needAdminRole").hasRole("ADMIN")
                .antMatchers("/needUserRole").hasRole("USER")
                .antMatchers("/hello","/login","/loginInfo","/logoutSuccess")
                .permitAll()
                .anyRequest().authenticated();

        http.logout().logoutSuccessUrl("/logoutSuccess");

        http.csrf().disable();
        http.cors();

        http.exceptionHandling().accessDeniedHandler(handler);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
