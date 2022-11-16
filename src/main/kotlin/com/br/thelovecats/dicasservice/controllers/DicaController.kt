package com.br.thelovecats.dicasservice.controllers

import com.br.thelovecats.dicasservice.controllers.request.DicaRequest
import com.br.thelovecats.dicasservice.controllers.request.TipoDicaRequest
import com.br.thelovecats.dicasservice.entity.Dica
import com.br.thelovecats.dicasservice.entity.TipoDica
import com.br.thelovecats.dicasservice.repository.DicaRepository
import com.br.thelovecats.dicasservice.repository.TipoDicaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController()
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/adivinha")
class DicaController(@Autowired val dicaRepository: DicaRepository, @Autowired val tipoDicaRepository: TipoDicaRepository) {

    @GetMapping("/all")
    fun all(): MutableList<Dica> {
       return dicaRepository.findAll()
    }

    @GetMapping("/list-for-game/{numeroDicas}")
    fun getlistForGame(@PathVariable(value = "numeroDicas") numeroDeDicas: Int): MutableList<Dica> {
        //TODO: log
        println("Numero de dicas solicitada: $numeroDeDicas")

       return dicaRepository.findForGame(numeroDeDicas)
    }

    @PostMapping("/criar-dica")
    @ResponseStatus(HttpStatus.CREATED)
    fun criarDica(@RequestBody dicaRequest: DicaRequest): ResponseEntity<Any> {

        val tipoDica = tipoDicaRepository.findById(dicaRequest.tipo)

        if (tipoDica.isEmpty){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: Tipo de dica não encontrado!!")
        }

        val dica = Dica(titulo = dicaRequest.titulo, descricao = dicaRequest.descricao,
        tipo = tipoDica.get(), pontos = dicaRequest.pontos)
        dicaRepository.save(dica)

        return ResponseEntity.status(HttpStatus.OK).body(dica)
    }
}