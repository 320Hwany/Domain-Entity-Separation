package domain_entity_separation.dto.member;

public record MemberLoginRequest(
        String loginId,
        String password
) {
}
