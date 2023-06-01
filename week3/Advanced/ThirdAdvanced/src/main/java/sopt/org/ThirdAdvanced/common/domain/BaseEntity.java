package sopt.org.ThirdAdvanced.common.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //현재 이 엔티티 클래스를 다른 모든 엔티티들이 상속 받아야 하므로 어노테이션 붙여줌
@EntityListeners(AuditingEntityListener.class) //JPA가 엔티티의 영속, 수정 이벤트를 감지해서 Auditing을 하도록 힘
public abstract class BaseEntity {
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
