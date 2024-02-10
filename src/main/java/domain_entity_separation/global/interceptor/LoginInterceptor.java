package domain_entity_separation.global.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object handler) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new IllegalArgumentException("세션이 존재하지 않습니다");
        }

        String jsonSession = (String) session.getAttribute("MemberSession");

        if (jsonSession == null) {
            throw new IllegalArgumentException("세션이 존재하지 않습니다");
        }

        request.setAttribute("MemberSession", jsonSession);
        return true;
    }
}
