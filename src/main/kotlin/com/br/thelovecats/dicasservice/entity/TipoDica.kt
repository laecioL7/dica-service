package com.br.thelovecats.dicasservice.entity

import org.hibernate.annotations.Comment
import javax.persistence.*

@Entity(name = "tb_tipo_dica")
class TipoDica(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true, length = 50)
    @Comment(value = "Titulo do tipo da dica")
    var descricao: String,

    ) {

}