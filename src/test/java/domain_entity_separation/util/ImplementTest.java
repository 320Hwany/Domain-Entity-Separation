package domain_entity_separation.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain_entity_separation.persistence.repository.basket.BasketRepository;
import domain_entity_separation.persistence.repository.item.ItemRepository;
import domain_entity_separation.persistence.repository.member.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public abstract class ImplementTest {

    @Autowired
    protected DatabaseCleaner databaseCleaner;

    @Autowired
    protected MemberRepository memberRepository;

    @Autowired
    protected ItemRepository itemRepository;

    @Autowired
    protected BasketRepository basketRepository;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUpDatabase() {
        databaseCleaner.cleanUp();
    }
}
