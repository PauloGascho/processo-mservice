package com.api.processosmservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(
        name = "processo"
)
@NoArgsConstructor
public class Processo {
    @Id
    @NotNull
    Integer numero;

    @NotBlank
    @NonNull
    String descricao;
    String reu;
}
