package br.senac.noteapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.senac.noteapp.databinding.ActivityNewNoteBinding
import br.senac.noteapp.model.Note
import br.senac.noteapp.model.NoteSingleton

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener{
            var titulo = binding.etTitle.text.toString()
            var desc = binding.etDesc.text.toString()
            val note = Note(titulo,desc)

            NoteSingleton.noteList.add(note)

            //acaba com esse ciclo
            finish()
        }

    }

}