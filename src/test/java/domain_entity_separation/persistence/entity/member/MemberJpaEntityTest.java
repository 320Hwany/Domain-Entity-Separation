package domain_entity_separation.persistence.entity.member;

import domain_entity_separation.dto.member.MemberSignupRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;

class MemberJpaEntityTest {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @DisplayName("회원 가입을 위한 DB 엔티티 생성시 비밀번호가 암호화됩니다.")
    @Test
    void createSignupEntity() {
        // given
        MemberSignupRequest memberSignupRequest = MemberSignupRequest.builder()
                .loginId("loginId")
                .password("password")
                .username("username")
                .build();

        // when
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.createSignupEntity(memberSignupRequest, passwordEncoder);

        // then
        assertThat(passwordEncoder.matches("password", memberJpaEntity.getPassword())).isTrue();
    }

    @DisplayName("주문 금액만큼 회원의 돈을 차감합니다.")
    @Test
    void subtractOrderPrice() {
        // given
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .money(10000)
                .build();

        // when
        memberJpaEntity.subtractOrderPrice(5000);

        // then
        assertThat(memberJpaEntity.getMoney()).isEqualTo(5000);
    }
}