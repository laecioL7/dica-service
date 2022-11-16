package com.br.thelovecats.dicasservice.repository

import com.br.thelovecats.dicasservice.entity.TipoDica
import org.springframework.data.jpa.repository.JpaRepository

interface TipoDicaRepository: JpaRepository<TipoDica,Long> {

}