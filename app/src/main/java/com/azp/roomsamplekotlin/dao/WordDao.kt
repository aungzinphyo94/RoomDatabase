package com.azp.roomsamplekotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.azp.roomsamplekotlin.entity.Word

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    @Delete
    fun delete(word: Word)

    @Update
    fun updateWord(vararg words: Word)

}