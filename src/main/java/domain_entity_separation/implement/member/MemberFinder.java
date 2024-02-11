package domain_entity_separation.implement.member;

import domain_entity_separation.global.annotation.Implement;
import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import domain_entity_separation.persistence.repository.member.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

@Implement
public class MemberFinder {

    private final MemberRepository memberRepository;

    public MemberFinder(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public MemberJpaEntity getByIdWithPessimisticLock(final long memberId) {
        return memberRepository.getByIdWithPessimisticLock(memberId);
    }
}
