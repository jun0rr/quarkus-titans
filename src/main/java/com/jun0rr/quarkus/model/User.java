/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jun0rr.quarkus.model;

import java.util.Objects;


/**
 *
 * @author Juno
 */
public class User {
  
  private long id;
  
  private String name;
  
  private String email;
  
  public User() {
    this.id = 0;
    this.name = "";
    this.email = "";
  }
  
  public User(long id, String name, String email) {
    this.id = id;
    this.name = Objects.requireNonNull(name);
    this.email = Objects.requireNonNull(email);
  }
  
  public long getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  @Override
  public User clone() {
    return new User(id, name, email);
  }
  
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 29 * hash + Objects.hashCode(this.name);
    hash = 29 * hash + Objects.hashCode(this.email);
    return hash;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final User other = (User) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.email, other.email)) {
      return false;
    }
    return true;
  }
  
  @Override
  public String toString() {
    return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
  }
  
}
