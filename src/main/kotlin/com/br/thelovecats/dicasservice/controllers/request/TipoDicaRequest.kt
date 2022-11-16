package com.br.thelovecats.dicasservice.controllers.request

import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotBlank


@JsonInclude(JsonInclude.Include.NON_NULL)
class TipoDicaRequest(
    @field:NotBlank
    val descricao: String
) {
}