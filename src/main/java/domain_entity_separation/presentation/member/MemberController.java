package domain_entity_separation.presentation.member;

import domain_entity_separation.application.member.MemberService;
import domain_entity_separation.dto.member.MemberLoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    public void login(@RequestBody final MemberLoginRequest memberLoginRequest,
                      final HttpServletRequest request) {
        memberService.login(memberLoginRequest, request);
    }
}
