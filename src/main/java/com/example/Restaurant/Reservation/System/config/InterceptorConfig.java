package com.example.Restaurant.Reservation.System.config;

import com.example.Restaurant.Reservation.System.aop.RestaurantInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final RestaurantInterceptor restaurantInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restaurantInterceptor).addPathPatterns("/api/restaurant/*");
    }


}
