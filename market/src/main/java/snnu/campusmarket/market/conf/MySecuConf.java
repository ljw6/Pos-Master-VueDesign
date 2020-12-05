package snnu.campusmarket.market.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import snnu.campusmarket.market.Authentication.JwtAuthenticationTokenFilter;
import snnu.campusmarket.market.Authentication.MyLoginEntryPoint;
import snnu.campusmarket.market.service.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecuConf extends WebSecurityConfigurerAdapter {


    @Autowired
    MyLoginEntryPoint myLoginEntryPoint;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationTokenFilter filter;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.route.authentication.path}")
    private String path;

//    @Autowired
//    private MyAccessDeniedHandler handler;
//
//    @Autowired
//    private UserLoginService userLoginService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("authenticationPath:"+path);
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(myLoginEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().antMatchers(path,"/last_lists").permitAll()
                .anyRequest().authenticated()
                .and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class); //添加拦截器到验证之前

        http.headers()
                .frameOptions().sameOrigin()
                .cacheControl();

        http.logout().logoutSuccessUrl("/logoutSuccess");

        http.cors();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.POST,path)
                .and().ignoring()
                .antMatchers(HttpMethod.GET,"/last_list");
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
