package com.example.teamb4spring.enums;

import lombok.Getter;

@Getter
public enum ContentType {
  MOVIE(" (Movie)"),
  TV_SHOW(" (Tv show)");

  private final String value;

  ContentType(String value) {
    this.value = value;
  }
}
