package com.github.alebabai.lindenhoney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(exclude = {"verses"})
@ToString(exclude = {"verses"})
@Entity
@Table(name = "song")
public class Song implements Persistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song_id_seq")
    @SequenceGenerator(name = "song_id_seq", sequenceName = "song_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "song", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Verse> verses = new ArrayList<>();

    public Song(String title, String author, List<Verse> verses) {
        this.title = title;
        this.author = author;
        this.setVerses(verses);
    }

    public Song setVerses(List<Verse> verses) {
        this.verses.clear();
        this.verses.addAll(verses);
        return this;
    }

    @JsonIgnore
    @Override
    public Long getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return id == null;
    }
}
