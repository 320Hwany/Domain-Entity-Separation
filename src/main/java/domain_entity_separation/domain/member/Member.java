package domain_entity_separation.domain.member;

import lombok.Builder;

@Builder
public record Member(
        String loginId,
        String password,
        String username,
        long money
) {
}
