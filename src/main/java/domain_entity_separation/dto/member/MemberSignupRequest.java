package domain_entity_separation.dto.member;

import lombok.Builder;

@Builder
public record MemberSignupRequest(
        String loginId,
        String password,
        String username
) {
}
