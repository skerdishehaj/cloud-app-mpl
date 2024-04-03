package com.hendisantika.springbootrestapipostgresql.entity;

import jakarta.persistence.*;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
  @SequenceGenerator(name = "author_seq", sequenceName = "author_seq", allocationSize = 1)
  private Long id;
  private String name;
  private String email;
  private String biography;
  private int age;

  public Author() {
  }

  public Author(String name, String email, String biography, int age) {
    this.name = name;
    this.email = email;
    this.biography = biography;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", biography='" + biography + '\'' +
        ", age=" + age +
        '}';
  }
}
