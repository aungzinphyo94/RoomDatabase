package com.azp.roomsamplekotlin.repository

import androidx.lifecycle.LiveData
import com.azp.roomsamplekotlin.dao.WordDao
import com.azp.roomsamplekotlin.entity.Word

class WordRepository (private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }


}