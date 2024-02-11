package domain_entity_separation.persistence.repository.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import jakarta.persistence.LockModeType;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;

import static domain_entity_separation.persistence.entity.member.QMemberJpaEntity.memberJpaEntity;


@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;
    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(final MemberJpaRepository memberJpaRepository,
                                final JPAQueryFactory queryFactory) {
        this.memberJpaRepository = memberJpaRepository;
        this.queryFactory = queryFactory;
    }

    @Override
    public void save(final MemberJpaEntity memberJpaEntity) {
        memberJpaRepository.save(memberJpaEntity);
    }

    @Override
    public MemberJpaEntity getByIdWithPessimisticLock(final long memberId) {
        MemberJpaEntity findEntity = queryFactory.selectFrom(memberJpaEntity)
                .where(memberJpaEntity.id.eq(memberId))
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .fetchFirst();

        if (findEntity == null) {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }

        return findEntity;
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
