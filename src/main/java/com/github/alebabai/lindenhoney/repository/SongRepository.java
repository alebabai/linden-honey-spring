package com.github.alebabai.lindenhoney.repository;

import com.github.alebabai.lindenhoney.domain.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "songs", collectionResourceRel = "songs")
public interface SongRepository extends PagingAndSortingRepository<Song, Long> {

    @RestResource(exported = false)
    @Override
    <S extends Song> S save(S song);

    @RestResource(exported = false)
    @Override
    void delete(Long id);
}
