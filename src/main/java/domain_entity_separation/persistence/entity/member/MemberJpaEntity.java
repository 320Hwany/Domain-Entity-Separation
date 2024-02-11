package domain_entity_separation.persistence.entity.member;

import domain_entity_separation.dto.member.MemberSignupRequest;
import domain_entity_separation.persistence.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Table(name = "member")
@Entity
public class MemberJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String loginId;

    private String password;

    private String username;

    private long money;

    protected MemberJpaEntity() {
    }

    @Builder
    private MemberJpaEntity(final String loginId, final String password,
                            final String username, final long money) {
        this.loginId = loginId;
        this.password = password;
        this.username = username;
        this.money = money;
    }

    public static MemberJpaEntity createSignupEntity(final MemberSignupRequest memberSignupRequest,
                                                     final PasswordEncoder passwordEncoder) {
        return MemberJpaEntity.builder()
                .loginId(memberSignupRequest.loginId())
                .password(passwordEncoder.encode(memberSignupRequest.password()))
                .username(memberSignupRequest.username())
                .money(0L)
                .build();
    }

    public void subtractOrderPrice(final long orderPrice) {
        this.money -= orderPrice;
    }
}
