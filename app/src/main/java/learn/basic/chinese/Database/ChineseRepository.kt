package com.jam.cookingina.Database

import androidx.lifecycle.LiveData
import learn.basic.chinese.Database.ChineseDao
import learn.basic.chinese.Database.ChineseModel

class ChineseRepository(private val chineseTablesDao: ChineseDao) {

 val getAlldata : LiveData<List<ChineseModel>> = chineseTablesDao.getAllChineseTable()

  fun getAlldata(): LiveData<List<ChineseModel>> {
    return chineseTablesDao.getAllChineseTable()
  }

}
