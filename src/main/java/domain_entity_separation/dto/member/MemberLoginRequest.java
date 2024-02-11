package domain_entity_separation.dto.member;

import lombok.Builder;

@Builder
public record MemberLoginRequest(
        String loginId,
        String password
) {
}
