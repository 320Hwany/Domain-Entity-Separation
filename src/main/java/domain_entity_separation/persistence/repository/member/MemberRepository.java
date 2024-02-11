package domain_entity_separation.persistence.repository.member;

import domain_entity_separation.persistence.entity.member.MemberJpaEntity;

public interface MemberRepository {

    void save(final MemberJpaEntity memberJpaEntity);

    MemberJpaEntity getByIdWithPessimisticLock(final long memberId);

    MemberJpaEntity getByLoginId(final String loginId);

    long count();
}
