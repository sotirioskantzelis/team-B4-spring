package com.example.teamb4spring.controller;

import com.example.teamb4spring.domain.BaseModel;
import com.example.teamb4spring.service.BaseService;
import com.example.teamb4spring.transfer.ApiResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class AbstractController <T extends BaseModel> extends BaseModel {

  protected abstract BaseService<T,Long> getBaseService();

  @GetMapping
  public ResponseEntity<ApiResponse<List<T>>> findAll() {
    return new ResponseEntity<>(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).build(),
        HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<T>> get(@PathVariable Long id) {
    return ResponseEntity.ok(ApiResponse.<T>builder().data(getBaseService().get(id)).build());
  }

}
