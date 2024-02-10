package domain_entity_separation.global.argument_resolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain_entity_separation.domain.member.MemberSession;
import domain_entity_separation.global.annotation.Login;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginArgumentResolver implements HandlerMethodArgumentResolver {

    private final ObjectMapper objectMapper;

    public LoginArgumentResolver(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        boolean hasMemberSessionType = parameter.getParameterType().equals(MemberSession.class);
        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
        return hasMemberSessionType && hasLoginAnnotation;
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer,
                                  final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) {
        HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        assert httpServletRequest != null;
        String jsonSession = (String) httpServletRequest.getAttribute("MemberSession");

        try {
            return objectMapper.readValue(jsonSession, MemberSession.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Json을 세션 정보로 파싱할 수 없습니다");
        }
    }
}
