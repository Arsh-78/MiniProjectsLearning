package com.example.mynotes1.Note

import android.media.CamcorderProfile.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.ResourceManagerInternal.get
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes1.R
import java.lang.reflect.Array.get

class NoteListAdapter(val itemClickListener: OnItemClickListener) : ListAdapter<Note, NoteListAdapter.NoteViewHolder>(NotesComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.note,itemClickListener)
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val NoteItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String? ,clickListener: OnItemClickListener) {
            NoteItemView.text = text
            NoteItemView.setOnClickListener {
                clickListener.onItemClicked(NoteItemView)
            }
        }

        companion object {
            fun create(parent: ViewGroup): NoteViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return NoteViewHolder(view)
            }
        }
    }

    fun getNoteAtPosition(position: Int): Note? {
        return getItem(position)
    }




    class NotesComparator : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.note == newItem.note
        }

    }
}
interface OnItemClickListener{
    fun onItemClicked(note: TextView)
}