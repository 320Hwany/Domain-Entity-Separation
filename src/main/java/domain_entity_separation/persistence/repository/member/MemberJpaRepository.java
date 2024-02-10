package domain_entity_separation.persistence.repository.member;

import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {

    Optional<MemberJpaEntity> findByLoginId(final String loginId);
}
