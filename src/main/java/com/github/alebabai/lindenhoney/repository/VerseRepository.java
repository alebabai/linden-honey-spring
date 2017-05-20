package com.github.alebabai.lindenhoney.repository;

import com.github.alebabai.lindenhoney.domain.Verse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "verses", collectionResourceRel = "verses")
public interface VerseRepository extends PagingAndSortingRepository<Verse, Integer> {

    @RestResource(exported = false)
    @Override
    <S extends Verse> S save(S verse);

    @RestResource(exported = false)
    @Override
    void delete(Integer id);

    @RestResource(exported = false)
    @Override
    void delete(Verse verse);

    @RestResource(path = "random", rel = "random")
    @Query(value = "SELECT * FROM VERSE ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Verse findRandomSong();
}
