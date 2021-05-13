package br.edu.infnet.exemplobancodedados.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.infnet.exemplobancodedados.dao.LivroDAO
import br.edu.infnet.exemplobancodedados.util.Livro
import java.security.AccessControlContext

@Database (
    entities = arrayOf(Livro::class),
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun livroDAO(): LivroDAO

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase ?= null

        fun getInsance(context: Context):AppDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "appDatabase.bd"
                ).build()
            }
            return INSTANCE!!
        }
    }
}