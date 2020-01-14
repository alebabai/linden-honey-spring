package com.github.lindenhoney.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "song")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(exclude = {"verses"})
@ToString(exclude = {"verses"})
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "album")
    private String album;

    @NotEmpty
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @OrderColumn(name = "index", nullable = false)
    @JoinColumn(name = "song_id", referencedColumnName = "id", nullable = false, updatable = false)
    private List<VerseEntity> verses = new ArrayList<>();
}
