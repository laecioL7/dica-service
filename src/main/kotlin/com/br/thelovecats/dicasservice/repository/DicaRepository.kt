package com.br.thelovecats.dicasservice.repository

import com.br.thelovecats.dicasservice.entity.Dica
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DicaRepository: JpaRepository<Dica,Long> {

    @Query(value = "SELECT id, descricao, pontos, titulo, usada, tipo_dica_id " +
            "FROM tb_dica order by random() limit 8", nativeQuery = true)
    fun findForGameDefault(): MutableList<Dica>

    @Query(value = "SELECT id, descricao, pontos, titulo, usada, tipo_dica_id " +
            "FROM tb_dica order by random() limit ?1", nativeQuery = true)
    fun findForGame(numeroDeDicas: Int): MutableList<Dica>
}