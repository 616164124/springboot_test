package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class CorseConfig implements WebMvcConfigurer {
   /*  private CorsConfiguration corsConfig() {
         CorsConfiguration corsConfiguration = new CorsConfiguration();
    // // 请求常用的三种配置，*代表允许所有，当时你也可以自定义属性（比如header只能带什么，只能是post方式等等）
         corsConfiguration.addAllowedOrigin("*");
         corsConfiguration.addAllowedHeader("*");
         corsConfiguration.addAllowedMethod("*");
         corsConfiguration.setAllowCredentials(true);
         corsConfiguration.setMaxAge(3600L);
         return corsConfiguration;
     }
     @Bean
     public CorsFilter corsFilter() {
         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         source.registerCorsConfiguration("/**", corsConfig());
         return new CorsFilter(source);
     }*/

   //axios 跨域解决
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //这里：是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
    }
}
