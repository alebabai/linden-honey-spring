package com.github.lindenhoney.domain;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = {"quotes"})
@ToString(exclude = {"quotes"})
public class Verse {

    @Valid
    @NotEmpty
    private final List<Quote> quotes;
}
