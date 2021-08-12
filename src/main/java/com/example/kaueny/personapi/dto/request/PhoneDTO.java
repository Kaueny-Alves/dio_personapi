package com.example.kaueny.personapi.dto.request;

import com.example.kaueny.personapi.enums.PhoneType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

  private Long id;

  @Enumerated(EnumType.STRING)
  private PhoneType type;

  @NotNull
  private String number;
}
