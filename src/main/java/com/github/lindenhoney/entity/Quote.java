package com.github.lindenhoney.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "quote")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "phrase", nullable = false)
    private String phrase;
}
