package domain_entity_separation.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;


class MemberTest {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @DisplayName("비밀번호가 일치하면 메소드를 통과합니다.")
    @Test
    void validatePassword() {
        // given
        Member member = Member.builder()
                .loginId("loginId")
                .password(passwordEncoder.encode("password"))
                .build();

        // expected
        member.validatePassword(passwordEncoder, "password");
    }

    @DisplayName("비밀번호가 일치하지 않으면 예외가 발생합니다.")
    @Test
    void validatePasswordFail() {
        // given
        Member member = Member.builder()
                .loginId("loginId")
                .password(passwordEncoder.encode("password"))
                .build();

        // expected
        assertThatThrownBy(() -> member.validatePassword(passwordEncoder, "일치하지 않는 비밀번호"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아이디/비밀번호가 일치하지 않습니다.");
    }
}