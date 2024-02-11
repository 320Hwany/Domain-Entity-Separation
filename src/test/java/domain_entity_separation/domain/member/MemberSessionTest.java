package domain_entity_separation.domain.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;


class MemberSessionTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("회원 정보로 세션을 생성합니다.")
    @Test
    void makeSession() {
        // given
        MemberSession memberSession = MemberSession.builder()
                .memberId(1L)
                .loginId("loginId")
                .username("username")
                .money(10000)
                .build();

        HttpServletRequest httpServletRequest = new MockHttpServletRequest();

        // when
        memberSession.makeSession(httpServletRequest, objectMapper);

        // then
        HttpSession session = httpServletRequest.getSession(false);
        assertThat(session).isNotNull();
        assertThat(session.getAttribute("MemberSession")).isNotNull();
    }
}