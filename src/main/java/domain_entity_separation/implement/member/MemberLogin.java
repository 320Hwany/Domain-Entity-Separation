package domain_entity_separation.implement.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain_entity_separation.domain.member.Member;
import domain_entity_separation.domain.member.MemberSession;
import domain_entity_separation.dto.member.MemberLoginRequest;
import domain_entity_separation.global.annotation.Implement;
import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import domain_entity_separation.persistence.repository.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


@Implement
public class MemberLogin {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;

    public MemberLogin(final MemberRepository memberRepository,
                       final PasswordEncoder passwordEncoder,
                       final ObjectMapper objectMapper) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public void login(final MemberLoginRequest memberLoginRequest, final HttpServletRequest httpServletRequest) {
        MemberJpaEntity memberJpaEntity = memberRepository.getByLoginId(memberLoginRequest.loginId());
        validatePassword(memberLoginRequest, memberJpaEntity);
        makeSession(httpServletRequest, memberJpaEntity);
    }

    private void validatePassword(final MemberLoginRequest memberLoginRequest,
                                  final MemberJpaEntity memberJpaEntity) {
        Member member = Member.toDomain(memberJpaEntity);
        member.validatePassword(passwordEncoder, memberLoginRequest.password());
    }

    private void makeSession(final HttpServletRequest httpServletRequest,
                             final MemberJpaEntity memberJpaEntity) {
        MemberSession memberSession = MemberSession.toDomain(memberJpaEntity);
        memberSession.makeSession(httpServletRequest, objectMapper);
    }
}
