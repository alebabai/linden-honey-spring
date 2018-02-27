package com.github.lindenhoney.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SongPreview {
    //TODO refine properties validation (for all cases, persistence and parser)

    @NotNull
    private Long id;

    @NotBlank
    private String title;
}
