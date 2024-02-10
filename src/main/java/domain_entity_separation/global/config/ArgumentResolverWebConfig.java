package domain_entity_separation.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain_entity_separation.global.argument_resolver.LoginArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ArgumentResolverWebConfig implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    public ArgumentResolverWebConfig(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginArgumentResolver(objectMapper));
    }
}
