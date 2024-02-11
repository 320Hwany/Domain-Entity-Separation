package domain_entity_separation.implement.member;

import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import domain_entity_separation.util.ImplementTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

class MemberFinderTest extends ImplementTest {

    @Autowired
    private MemberFinder memberFinder;

    @DisplayName("회원 id로 회원 정보를 가져옵니다.")
    @Test
    void getByIdWithPessimisticLock() {
        // given
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .loginId("loginId")
                .build();

        memberRepository.save(memberJpaEntity);

        // when
        MemberJpaEntity findEntity = memberFinder.getByIdWithPessimisticLock(memberJpaEntity.getId());

        // then
        assertThat(findEntity).isNotNull();
    }
}