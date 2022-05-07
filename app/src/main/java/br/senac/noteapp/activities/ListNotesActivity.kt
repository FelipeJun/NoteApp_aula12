package br.senac.noteapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.senac.noteapp.databinding.ActivityListNotesBinding
import br.senac.noteapp.databinding.NoteBinding
import br.senac.noteapp.model.NoteSingleton

class ListNotesActivity : AppCompatActivity() {
    lateinit var binding: ActivityListNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
            binding.fab.setOnClickListener{
                val intent = Intent(this, NewNoteActivity::class.java)
                startActivity(intent)
            }
    }

    //on resume executa toda vez que volta para a tela
    override fun onResume() {
        super.onResume()
        refreshNotes()
    }

    fun refreshNotes(){
        //Limpa a view, tirando todos os seus filhos
        binding.container.removeAllViews()

        NoteSingleton.noteList.forEach {
            //instancia dinamicamente o xml
            val cardBinding = NoteBinding.inflate(layoutInflater)

            cardBinding.textTitle.text = it.title
            cardBinding.textDesc.text = it.desc

            binding.container.addView(cardBinding.root)

        }
    }
}