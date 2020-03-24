package com.github.lindenhoney.repository;

import com.github.lindenhoney.entity.QuoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends Repository<QuoteEntity, Integer> {

    @Query(value = "SELECT * FROM QUOTE ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<QuoteEntity> findRandomQuote();

    @Query(value = "SELECT * FROM QUOTE q WHERE q.verse_id IN (SELECT v.id FROM VERSE v WHERE v.song_id = :songId) ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<QuoteEntity> findRandomQuoteFromSong(@Param("songId") Integer songId);

    @Query(
            value = "SELECT DISTINCT ON (q.phrase) * FROM QUOTE q WHERE q.phrase ILIKE %:phrase%",
            countQuery = "SELECT COUNT(DISTINCT q.phrase) FROM QUOTE q WHERE q.phrase ILIKE %:phrase%",
            nativeQuery = true
    )
    Page<QuoteEntity> findQuotesByPhrase(@Param("phrase") String phrase, Pageable pageable);

    @Query(
            value = "SELECT DISTINCT ON (q.phrase) * " +
                    "FROM QUOTE q " +
                    "WHERE q.verse_id IN (SELECT v.id FROM VERSE v WHERE v.song_id = :songId) AND q.phrase ILIKE %:phrase%",
            nativeQuery = true
    )
    List<QuoteEntity> findQuotesByPhraseFromSong(@Param("songId") Integer songId, @Param("phrase") String phrase);

    @Query(value = "SELECT * FROM QUOTE q WHERE q.verse_id IN (SELECT v.id FROM VERSE v WHERE v.song_id = :songId)", nativeQuery = true)
    List<QuoteEntity> findAllQuotesFromSong(@Param("songId") Integer songId);
}
