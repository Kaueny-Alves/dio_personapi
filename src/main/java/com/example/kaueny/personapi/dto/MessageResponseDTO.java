package com.example.kaueny.personapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {
  private String message;
}
