package com.hendisantika.springbootrestapipostgresql.controller;

import com.hendisantika.springbootrestapipostgresql.entity.Author;
import com.hendisantika.springbootrestapipostgresql.repository.AuthorRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {
  private static final Logger logger = LoggerFactory.getLogger(AuthorRestController.class);

  @Autowired
  private AuthorRepository repository;

  @PostMapping
  public ResponseEntity<?> addAuthor(@RequestBody Author author) {
    logger.debug("addAuthor({}) called", author.getName());
    logger.info("Adding author {}", author);
    return new ResponseEntity<>(repository.save(author), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Collection<Author>> getAllAuthors() {
    logger.debug("getAllAuthors() called");
    logger.info("Getting all authors");
    return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getAuthorWithId(@PathVariable Long id) {
    logger.debug("getAuthorWithId() called with: id = [" + id + "]");
    logger.info("Getting author with id {}", id);
    return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
  }

  @GetMapping(params = {"name"})
  public ResponseEntity<Collection<Author>> findAuthorWithName(@RequestParam(value = "name") String name) {
    logger.debug("findAuthorWithName() called with: name = [" + name + "]");
    logger.info("Getting author with name {}", name);
    return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Author> updateAuthorFromDB(@PathVariable("id") long id, @RequestBody Author author) {
    logger.debug("updateAuthorFromDB() called with: id = [" + id + "], author = [" + author + "]");
    logger.info("Updating author with id {}", id);
    Optional<Author> currentAuthorOpt = repository.findById(id);
    Author currentAuthor = currentAuthorOpt.get();
    currentAuthor.setName(author.getName());
    currentAuthor.setEmail(author.getEmail());
    currentAuthor.setBiography(author.getBiography());
    currentAuthor.setAge(author.getAge());

    return new ResponseEntity<>(repository.save(currentAuthor), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthorWithId(@PathVariable Long id) {
    logger.debug("deleteAuthorWithId() called with: id = [" + id + "]");
    logger.info("Deleting author with id {}", id);
    repository.deleteById(id);
  }

  @DeleteMapping
  public void deleteAllAuthors() {
    logger.debug("deleteAllAuthors() called");
    logger.info("Deleting all authors");
    repository.deleteAll();
  }
}
