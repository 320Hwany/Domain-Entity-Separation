package domain_entity_separation.persistence.repository.member;

import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {
}
