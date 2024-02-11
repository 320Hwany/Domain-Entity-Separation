package domain_entity_separation.persistence.repository.member;

import domain_entity_separation.persistence.entity.member.MemberJpaEntity;

import java.util.Optional;

public interface MemberRepository {

    void save(final MemberJpaEntity memberJpaEntity);

    MemberJpaEntity getByLoginId(final String loginId);

    long count();
}
