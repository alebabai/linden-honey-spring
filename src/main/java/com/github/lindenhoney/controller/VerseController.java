package com.github.lindenhoney.controller;

import com.github.lindenhoney.domain.Verse;
import com.github.lindenhoney.repository.VerseRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
@RequestMapping(path = "/verses/search")
public class VerseController {

    private final VerseRepository repository;

    public VerseController(VerseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("random")
    @ResponseBody
    public Resource<Verse> getRandomVerse() {
        final Verse verse = repository.findRandomVerse();
        return new Resource<>(verse, linkTo(methodOn(this.getClass()).getRandomVerse()).withSelfRel());
    }
}
