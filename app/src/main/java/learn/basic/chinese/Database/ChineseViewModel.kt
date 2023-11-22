package learn.basic.chinese.Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jam.cookingina.Database.ChineseRepository

class ChineseViewModel(repository: ChineseRepository) : ViewModel() {
    val allData: LiveData<List<ChineseModel>> = repository.getAlldata()

    fun getAllDatas(): LiveData<List<ChineseModel>> {
        return allData
    }

}
