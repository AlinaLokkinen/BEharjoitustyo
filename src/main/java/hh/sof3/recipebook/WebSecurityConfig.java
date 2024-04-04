// package hh.sof3.recipebook;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
// import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

// @Configuration
// public class WebSecurityConfig {


//     @Bean
//     public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(authorize -> authorize
//                 .requestMatchers(antMatcher("/css/**")).permitAll()
//                 .requestMatchers(toH2Console()).permitAll()
//                 .requestMatchers(("/index")).permitAll()
//                 .anyRequest().authenticated()
//             )
//             .formLogin( formlogin -> formlogin
//                 .loginPage("/login")
//                 .defaultSuccessUrl("/index", true)
//                 .permitAll()
//             )
//             .logout( logout -> logout
//                 .permitAll()
//             );
//             return http.build();


//     }
// }
