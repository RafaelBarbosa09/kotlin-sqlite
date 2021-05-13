package br.edu.infnet.exemplobancodedados.util

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Livro {

    @PrimaryKey(autoGenerate = true) val id: Int ?= null
    var descricao: String ?= null
    var autor: String ?= null

    constructor(descricao: String, autor: String ){
        this.descricao = descricao
        this.autor = autor
    }
}