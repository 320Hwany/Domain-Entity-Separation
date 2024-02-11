package domain_entity_separation.persistence.repository.member;

import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;


@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    public MemberRepositoryImpl(final MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public void save(final MemberJpaEntity memberJpaEntity) {
        memberJpaRepository.save(memberJpaEntity);
    }

    @Override
    public MemberJpaEntity getByLoginId(final String loginId) {
        return memberJpaRepository.findByLoginId(loginId)
                .orElseThrow(() -> new InvalidDataAccessApiUsageException("아이디/비밀번호가 일치하지 않습니다."));
    }

    @Override
    public long count() {
        return memberJpaRepository.count();
    }
}
