package com.azp.roomsamplekotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.azp.roomsamplekotlin.database.WordRoomDatabase
import com.azp.roomsamplekotlin.entity.Word
import com.azp.roomsamplekotlin.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository

    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application,viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}