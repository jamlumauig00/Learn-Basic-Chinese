package learn.basic.chinese.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query


@Dao
interface ChineseDao {
    @Query("SELECT * FROM ChineseTable")
    fun getAllChineseTable(): LiveData<List<ChineseModel>>

    @Query("SELECT * FROM ChineseTable WHERE Id = :id")
   // suspend fun getAllChineseTable(id: String): TableElement
    fun getAllChineseTable(id: String): LiveData<List<ChineseModel>>

}
