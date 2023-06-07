package sopt.org.SixthSeminar.domain;

import lombok.AccessLevel;
import lombok.Builder;
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

    @Column
    private String thumbnail;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Boolean isPublic;

    @OneToMany(mappedBy = "board")
    private List<BoardImage> boardImageList = new ArrayList<>();

    @Builder
    private Board(User user, String title, String content, Boolean isPublic, String thumbnail) {
        this.user = user;
        this.title =title;
        this.content = content;
        this.isPublic = isPublic;
        this.thumbnail = thumbnail;
    }

    public void addBoardImage(BoardImage boardImage) { this.boardImageList.add(boardImage); }
}