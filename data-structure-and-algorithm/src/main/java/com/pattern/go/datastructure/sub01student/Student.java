package com.pattern.go.datastructure.sub01student;

import java.util.Objects;

public class Student {

  private Integer id;
  private String name;
  private Integer gender;

  public Student(Integer id, String name, Integer gender) {

    this.id = id;
    this.name = name;
    this.gender = gender;
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, gender);
  }

  @Override
  public boolean equals(Object object) {

    if (this == object) {
      return true;
    } else if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Student another = (Student) object;

    return Objects.equals(id, another.id) && Objects.equals(name, another.name)
        && Objects.equals(gender, another.gender);
  }

  @Override
  public String toString() {

    return "Student [id=" + id + ", name=" + name + ", gender=" + gender + "]";
  }

  public Integer getId() {

    return id;
  }

  public void setId(Integer id) {

    this.id = id;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public Integer getGender() {

    return gender;
  }

  public void setGender(Integer gender) {

    this.gender = gender;
  }
}
