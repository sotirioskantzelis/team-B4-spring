package com.example.teamb4spring.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse <T> implements Serializable {
  String transactionId = UUID.randomUUID().toString().toUpperCase(Locale.ROOT);
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SS")
  LocalDateTime createdAt = LocalDateTime.now();
  T data;
//  ApiError apiError;
}
