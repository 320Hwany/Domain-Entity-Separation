package domain_entity_separation.persistence.repository.member;

import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    public MemberRepositoryImpl(final MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public MemberJpaEntity getById(final long memberId) {
        return memberJpaRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));
    }

    @Override
    public MemberJpaEntity getByLoginId(final String loginId) {
        return memberJpaRepository.findByLoginId(loginId)
                .orElseThrow(() -> new IllegalArgumentException("아이디/비밀번호가 일치하지 않습니다."));
    }
}
