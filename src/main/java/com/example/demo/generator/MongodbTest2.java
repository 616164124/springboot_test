package com.example.demo.generator;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collation = "one")
public class MongodbTest2 {

  private UUID Id;
  private String name;
  private int age;
  private Date date;
  private String code;

  public MongodbTest2(UUID id, String name, int age, Date date, String code) {
    UUID Id = id;
    this.name = name;
    this.age = age;
    this.date = date;
    this.code = code;
  }

  public UUID getId() {
    return Id;
  }

  public void setId(UUID id) {
    Id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
