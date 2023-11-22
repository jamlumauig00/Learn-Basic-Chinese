package learn.basic.chinese.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ChineseTable")
data class ChineseModel(
    val Chinese: String?,
    val English: String?,
    @PrimaryKey val Id: String = "",
    val Category: String?,
    val Pinyin: String?
)

