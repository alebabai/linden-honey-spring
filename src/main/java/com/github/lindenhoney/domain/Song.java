package com.github.lindenhoney.domain;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = {"verses"})
@ToString(exclude = {"verses"})
public class Song {

    @NotBlank
    private final String id;

    @NotBlank
    private final String title;

    private final String author;

    private final String album;

    @Valid
    @NotEmpty
    private final List<Verse> verses;
}
