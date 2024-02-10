package domain_entity_separation.implement.member;

import domain_entity_separation.dto.member.MemberSignupRequest;
import domain_entity_separation.global.annotation.Implement;
import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import domain_entity_separation.persistence.repository.member.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Implement
public class MemberSignup {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberSignup(final MemberRepository memberRepository, final PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void signup(final MemberSignupRequest memberSignupRequest) {
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.createSignupEntity(memberSignupRequest, passwordEncoder);
        memberRepository.save(memberJpaEntity);
    }
}
