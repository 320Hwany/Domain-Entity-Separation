package domain_entity_separation.domain.member;

import domain_entity_separation.persistence.entity.member.MemberJpaEntity;
import lombok.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder
public record Member(
        String loginId,
        String password,
        String username,
        long money
) {

    public static Member toDomain(final MemberJpaEntity memberJpaEntity) {
        return Member.builder()
                .loginId(memberJpaEntity.getLoginId())
                .password(memberJpaEntity.getPassword())
                .username(memberJpaEntity.getUsername())
                .money(memberJpaEntity.getMoney())
                .build();
    }

    public void validatePassword(final PasswordEncoder passwordEncoder, final String rawPassword) {
        if (!passwordEncoder.matches(rawPassword, password)) {
            throw new IllegalArgumentException("아이디/비밀번호가 일치하지 않습니다.");
        }
    }
}
