package com.br.thelovecats.dicasservice.controllers.request

import com.br.thelovecats.dicasservice.entity.TipoDica
import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotBlank

@JsonInclude(JsonInclude.Include.NON_NULL)
class DicaRequest(
    @field:NotBlank
    val titulo: String,
    @field:NotBlank
    val descricao: String,
    @field:NotBlank
    var tipo: Long,
    @field:NotBlank
    val pontos: Int
) {
}