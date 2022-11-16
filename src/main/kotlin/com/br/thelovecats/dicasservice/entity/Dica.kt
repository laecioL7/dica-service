package com.br.thelovecats.dicasservice.entity

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.Comment
import javax.persistence.*

@Entity(name = "tb_dica")
/* quando for serializar o objeto só vai mostrar os campos
 que tiverem valor ignorando nulos */
@JsonInclude(JsonInclude.Include.NON_NULL)
class Dica(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true, length = 50)
    @Comment(value = "Titulo da dica")
    val titulo: String,

    @Column(nullable = false, unique = true, length = 250)
    @Comment(value = "descrição da dica")
    val descricao: String,

    @JoinColumn(name = "tipo_dica_id", nullable = false)
    @OneToOne
    var tipo: TipoDica,

    val pontos: Int,
    var usada: Boolean = false
    ) {

}