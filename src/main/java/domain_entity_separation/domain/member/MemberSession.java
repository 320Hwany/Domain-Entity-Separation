package domain_entity_separation.domain.member;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;

@Builder
public record MemberSession(
        long memberId,
        String loginId,
        String username,
        long money
) {

    public static MemberSession toDomain(final MemberJpaEntity memberJpaEntity) {
        return MemberSession.builder()
                .memberId(memberJpaEntity.getId())
                .loginId(memberJpaEntity.getLoginId())
                .username(memberJpaEntity.getUsername())
                .money(memberJpaEntity.getMoney())
                .build();
    }

    public void makeSession(final HttpServletRequest httpServletRequest,
                            final ObjectMapper objectMapper) {
        HttpSession session = httpServletRequest.getSession();

        try {
            String sessionJson = objectMapper.writeValueAsString(this);
            session.setAttribute("MemberSession", sessionJson);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("세션 정보를 Json으로 파싱할 수 없습니다.");
        }
    }
}
