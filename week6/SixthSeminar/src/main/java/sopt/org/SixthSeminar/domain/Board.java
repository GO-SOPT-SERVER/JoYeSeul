package sopt.org.SixthSeminar.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.SixthSeminar.common.domain.AuditingTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Board extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Boolean isPublic;

    private Board(User user, String title, String content, Boolean isPublic) {
        this.user = user;
        this.title =title;
        this.content = content;
        this.isPublic = isPublic;
    }

    public static Board newInstance(User user, String title, String content, Boolean isPublic) {
        return new Board(user, title, content, isPublic);
    }
}
