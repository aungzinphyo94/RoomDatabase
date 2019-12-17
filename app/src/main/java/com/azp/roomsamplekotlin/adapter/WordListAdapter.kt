package com.azp.roomsamplekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azp.roomsamplekotlin.R
import com.azp.roomsamplekotlin.entity.Word
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class WordListAdapter internal constructor(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private var words = emptyList<Word>() //cached copy of words
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.wordItem.text = current.word
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItem : TextView = itemView.findViewById(R.id.textView)
    }
}