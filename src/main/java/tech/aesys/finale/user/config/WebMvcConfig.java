package tech.aesys.finale.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.aesys.finale.user.resolver.UsernameResolver;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final UsernameResolver usernameResolver;

    // Constructor injection se usi @Component sul resolver
    public WebMvcConfig(UsernameResolver usernameResolver) {
        this.usernameResolver = usernameResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(usernameResolver);
    }
}