package meow.pasyagitka.findtrainingvideos.configuration;

import meow.pasyagitka.findtrainingvideos.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtFilter jwtFilter;


    //defines which URL paths should be secured and which should not.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //авторизировать пользователя по токену, не нужно создавать и хранить для него сессию. Поэтому я указал STATELESS.
                .and()
                .authorizeRequests()
                .antMatchers("/adminmain/*", "/adminmain").hasRole("ADMIN") // какие будут доступны для определенной роли, а какие нет.
                .antMatchers("/usermain/*", "/usermain").hasRole("USER")
                .antMatchers("/register", "/login").permitAll() //адреса register и auth будут доступны всем независимо от роли и авторизации.
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
                //будет срабатывать при каждом запросе - чтобы спринг как-то увидел пользователя в системе

                /*.authorizeRequests()
                .antMatchers("/").permitAll()// configured to not require any authentication.
                //All other paths must be authenticated.
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                //When a user successfully logs in, they are redirected to the previously requested page that required authentication.
                //There is a custom /login page (which is specified by loginPage()), and everyone is allowed to view it.
                .permitAll()
                .and()
                .logout()
                .permitAll();*/
    }

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}