package br.edu.infnet.exemplobancodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.exemplobancodedados.database.AppDatabase
import br.edu.infnet.exemplobancodedados.util.Livro

abstract class MainActivity : AppCompatActivity() {

    abstract var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val db = AppDatabase.getInsance(applicationContext)

        db.livroDAO().salvarLivro(
            Livro(
                descricao = "Harry Potter",
                autor = "Sei lá"
            )
        )
        Log.i("Livro", db.livroDAO().encontrarTodosOsLivros().size.toString())
    }
}