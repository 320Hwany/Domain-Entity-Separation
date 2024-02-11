package domain_entity_separation.implement.member;

import domain_entity_separation.dto.member.MemberLoginRequest;
import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import domain_entity_separation.util.ImplementTest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class MemberLoginTest extends ImplementTest {

    @Autowired
    private MemberLogin memberLogin;

    @DisplayName("아이디/비밀번호가 일치하면 세션 정보가 생성됩니다.")
    @Test
    void login() {
        // given
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .loginId("loginId")
                .password(passwordEncoder.encode("password"))
                .build();

        memberRepository.save(memberJpaEntity);

        MemberLoginRequest memberLoginRequest = MemberLoginRequest.builder()
                .loginId("loginId")
                .password("password")
                .build();

        HttpServletRequest httpServletRequest = new MockHttpServletRequest();

        // when
        memberLogin.login(memberLoginRequest, httpServletRequest);

        // then
        HttpSession session = httpServletRequest.getSession(false);
        assertThat(session).isNotNull();
    }

    @DisplayName("아이디가 일치하지 않으면 예외가 발생합니다.")
    @Test
    void loginFailNotMatchLoginId() {
        // given
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .loginId("loginId")
                .password(passwordEncoder.encode("password"))
                .build();

        memberRepository.save(memberJpaEntity);

        MemberLoginRequest memberLoginRequest = MemberLoginRequest.builder()
                .loginId("일치하지 않는 아이디")
                .password("password")
                .build();

        HttpServletRequest httpServletRequest = new MockHttpServletRequest();

        // when
        assertThatThrownBy(() -> memberLogin.login(memberLoginRequest, httpServletRequest))
                .isInstanceOf(InvalidDataAccessApiUsageException.class)
                .hasMessage("아이디/비밀번호가 일치하지 않습니다.");

        HttpSession session = httpServletRequest.getSession(false);
        assertThat(session).isNull();
    }

    @DisplayName("비밀번호가 일치하지 않으면 예외가 발생합니다.")
    @Test
    void loginFailNotMatchPassword() {
        // given
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .loginId("loginId")
                .password(passwordEncoder.encode("password"))
                .build();

        memberRepository.save(memberJpaEntity);

        MemberLoginRequest memberLoginRequest = MemberLoginRequest.builder()
                .loginId("loginId")
                .password("일치하지 않는 비밀번호")
                .build();

        HttpServletRequest httpServletRequest = new MockHttpServletRequest();

        // when
        assertThatThrownBy(() -> memberLogin.login(memberLoginRequest, httpServletRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아이디/비밀번호가 일치하지 않습니다.");

        HttpSession session = httpServletRequest.getSession(false);
        assertThat(session).isNull();
    }
}