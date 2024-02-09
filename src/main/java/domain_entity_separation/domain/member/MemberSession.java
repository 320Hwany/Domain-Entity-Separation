package domain_entity_separation.domain.member;

import lombok.Builder;

@Builder
public record MemberSession(
        String loginId,
        String username
) {
}
