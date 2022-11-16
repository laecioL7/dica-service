package com.br.thelovecats.dicasservice.controllers

import com.br.thelovecats.dicasservice.controllers.request.TipoDicaRequest
import com.br.thelovecats.dicasservice.entity.Dica
import com.br.thelovecats.dicasservice.entity.TipoDica
import com.br.thelovecats.dicasservice.repository.TipoDicaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController()
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/adivinha")
class TipoDicaController(@Autowired val tipoDicaRepository: TipoDicaRepository) {

    @PostMapping("/criar-tipo-dica")
    @ResponseStatus(HttpStatus.CREATED)
    fun criarTipoDica(@RequestBody tipoDicaRequest: TipoDicaRequest): ResponseEntity<Any> {

        val tipoDica = TipoDica(descricao = tipoDicaRequest.descricao)
        tipoDicaRepository.save(tipoDica)

        return ResponseEntity.status(HttpStatus.OK).body(tipoDica)
    }

    @GetMapping("/listar-tipos")
    fun all(): MutableList<TipoDica> {
        return tipoDicaRepository.findAll()
    }
}