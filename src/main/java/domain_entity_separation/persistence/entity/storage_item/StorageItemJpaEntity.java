package domain_entity_separation.persistence.entity.storage_item;

import domain_entity_separation.global.annotation.Association;
import domain_entity_separation.persistence.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "storage_item")
@Entity
public class StorageItemJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storage_item_id")
    private Long id;

    @Association
    private Long itemId;

    private Long totalQuantity;

    protected StorageItemJpaEntity() {
    }

    @Builder
    private StorageItemJpaEntity(final long itemId, final long totalQuantity) {
        this.itemId = itemId;
        this.totalQuantity = totalQuantity;
    }
}
