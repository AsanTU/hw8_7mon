package com.example.hw8_7mon.ui.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw8_7mon.data.model.NoteEntity
import com.example.hw8_7mon.databinding.ItemNoteBinding

class NoteAdapter(private val notes: List<NoteEntity>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }


    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteEntity) {
            binding.apply {
                titleTv.text = note.title
                contentTv.text = note.content
                categoryTv.text = note.category
                priorityTv.text = note.priority.toString()
            }
        }
    }
}