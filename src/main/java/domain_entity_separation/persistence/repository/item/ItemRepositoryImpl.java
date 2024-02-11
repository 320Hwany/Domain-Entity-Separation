package domain_entity_separation.persistence.repository.item;

import com.querydsl.jpa.impl.JPAQueryFactory;
import domain_entity_separation.persistence.entity.item.ItemJpaEntity;
import jakarta.persistence.LockModeType;
import org.springframework.stereotype.Repository;

import static domain_entity_separation.persistence.entity.item.QItemJpaEntity.itemJpaEntity;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;
    private final JPAQueryFactory queryFactory;

    public ItemRepositoryImpl(final ItemJpaRepository itemJpaRepository,
                              final JPAQueryFactory queryFactory) {
        this.itemJpaRepository = itemJpaRepository;
        this.queryFactory = queryFactory;
    }

    @Override
    public void save(final ItemJpaEntity itemJpaEntity) {
        itemJpaRepository.save(itemJpaEntity);
    }

    @Override
    public ItemJpaEntity getByIdWithPessimisticLock(final long itemId) {
        ItemJpaEntity findEntity = queryFactory.selectFrom(itemJpaEntity)
                .where(itemJpaEntity.id.eq(itemId))
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .fetchFirst();

        if (findEntity == null) {
            throw new IllegalArgumentException("상품 정보를 찾을 수 없습니다.");
        }

        return findEntity;
    }

    @Override
    public ItemJpaEntity getById(final long itemId) {
        return itemJpaRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("상품 정보를 찾을 수 없습니다."));
    }

    @Override
    public long count() {
        return itemJpaRepository.count();
    }
}
