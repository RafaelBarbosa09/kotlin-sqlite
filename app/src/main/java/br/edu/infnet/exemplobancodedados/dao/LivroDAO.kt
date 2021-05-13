package br.edu.infnet.exemplobancodedados.dao

import androidx.room.*
import br.edu.infnet.exemplobancodedados.util.Livro

@Dao
interface LivroDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salvarLivro(livro: Livro)

    @Delete
    fun deletarLivro(livro: Livro)

    @Query("SELECT * FROM livro")
    fun encontrarTodosOsLivros(): Array<Livro>

    @Query("SELECT * FROM livro WHERE id == :id")
    fun encontrarLivroPorId(id: Int)
}