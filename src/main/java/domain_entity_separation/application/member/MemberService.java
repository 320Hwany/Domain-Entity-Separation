package domain_entity_separation.application.member;

import domain_entity_separation.dto.member.MemberLoginRequest;
import domain_entity_separation.dto.member.MemberSignupRequest;
import domain_entity_separation.implement.member.MemberLogin;
import domain_entity_separation.implement.member.MemberSignup;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberSignup memberSignup;
    private final MemberLogin memberLogin;

    public MemberService(final MemberSignup memberSignup, final MemberLogin memberLogin) {
        this.memberSignup = memberSignup;
        this.memberLogin = memberLogin;
    }

    public void signup(final MemberSignupRequest memberSignupRequest) {
        memberSignup.signup(memberSignupRequest);
    }

    public void login(final MemberLoginRequest memberLoginRequest, final HttpServletRequest httpServletRequest) {
        memberLogin.login(memberLoginRequest, httpServletRequest);
    }
}
