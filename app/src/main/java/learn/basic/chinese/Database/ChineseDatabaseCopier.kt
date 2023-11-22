package com.jam.cookingina.Database

import android.content.Context
import java.io.File
import java.io.FileOutputStream

object ChineseDatabaseCopier {
    fun copyChineseDatabaseFromAssets(context: Context) {
        val databasePath = context.getDatabasePath("LearnBasicChinese.db").absolutePath

        if (!File(databasePath).exists()) {
            val inputStream = context.assets.open("LearnBasicChinese.db")
            val outputStream = FileOutputStream(databasePath)

            inputStream.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
        }
    }
}

