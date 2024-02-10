package domain_entity_separation.dto.member;

public record MemberSignupRequest(
        String loginId,
        String password,
        String username
) {
}
