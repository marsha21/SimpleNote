package com.example.simplenote.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.simplenote.database.Note

class NoteDiffCallBack (private val mOldNoteList: List<Note>,
                        private val mNewNoteList: List<Note>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldNoteList.size
    }

    override fun getNewListSize(): Int {
        return mNewNoteList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldNoteList[oldItemPosition].id == mNewNoteList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldNoteList[oldItemPosition]
        val newEmployee = mNewNoteList[newItemPosition]

        return oldEmployee.title == newEmployee.title && oldEmployee.description == newEmployee.description
    }
}
