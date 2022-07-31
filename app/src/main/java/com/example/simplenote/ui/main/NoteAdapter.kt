package com.example.simplenote.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenote.database.Note
import com.example.simplenote.databinding.ItemNoteBinding
import com.example.simplenote.helper.NoteDiffCallBack
import com.example.simplenote.ui.insert.NoteAddUpdateActivity

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private val listNote = ArrayList<Note>()

    fun setListNotes(notes: List<Note>){
        val diffCallBack = NoteDiffCallBack(listNote, notes)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        this.listNote.clear()
        this.listNote.addAll(notes)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            with(binding){
                tvItemDate.text = note.date
                tvItemTitle.text = note.title
                tvItemDescription.text = note.description
                cvItemNote.setOnClickListener {
                    val intent = Intent(it.context, NoteAddUpdateActivity::class.java)
                    intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, note)
                    it.context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemNoteBinding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(itemNoteBinding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNote[position])
    }

    override fun getItemCount(): Int = listNote.size
}