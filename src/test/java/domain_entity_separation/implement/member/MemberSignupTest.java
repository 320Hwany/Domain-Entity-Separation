package domain_entity_separation.implement.member;

import domain_entity_separation.dto.member.MemberSignupRequest;
import domain_entity_separation.util.ImplementTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

class MemberSignupTest extends ImplementTest {

    @Autowired
    private MemberSignup memberSignup;

    @DisplayName("입력한 정보로 회원 저장에 성공한다.")
    @Test
    void signup() {
        // given
        MemberSignupRequest memberSignupRequest = MemberSignupRequest.builder()
                .loginId("loginId")
                .password("password")
                .username("username")
                .build();

        // when
        memberSignup.signup(memberSignupRequest);

        // then
        assertThat(memberRepository.count()).isEqualTo(1);
    }
}