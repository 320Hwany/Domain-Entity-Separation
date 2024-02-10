package domain_entity_separation.application.member;

import domain_entity_separation.dto.member.MemberLoginRequest;
import domain_entity_separation.implement.member.MemberLogin;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberLogin memberLogin;

    public MemberService(final MemberLogin memberLogin) {
        this.memberLogin = memberLogin;
    }

    public void login(final MemberLoginRequest memberLoginRequest, final HttpServletRequest httpServletRequest) {
        memberLogin.login(memberLoginRequest, httpServletRequest);
    }
}
