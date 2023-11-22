package learn.basic.chinese

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.jam.cookingina.Database.ChineseRepository
import com.jam.cookingina.Database.ChineseViewModelFactory
import learn.basic.chinese.Database.AppDatabase
import learn.basic.chinese.Database.ChineseModel
import learn.basic.chinese.Database.ChineseViewModel

class ChineseClassGetData(context: Context) {
    private lateinit var chineseViewModel: ChineseViewModel
    private val repository = ChineseRepository(AppDatabase.getChineseDatabase(context).basicChineseDao())

    fun getData(data: String, context: Context, callback: (List<ChineseModel>) -> Unit) {
        chineseViewModel = ViewModelProvider(context as ViewModelStoreOwner, ChineseViewModelFactory(repository))[ChineseViewModel::class.java]

        val filteredItems = ArrayList<ChineseModel>()
        Log.e("data", data)

        chineseViewModel.allData.observe(context as LifecycleOwner) { datas ->
            // Handle the data here
           // Log.e("TABLEVIEWMODEL", datas.toString())

            for (value in datas) {
                value.Category?.let { Log.e("VALUE", it) }

                if (value.Category == data) {
                    Log.e("CategoryCategory", value.toString())
                    Log.e("CategoryV", value.Category.toString())
                    filteredItems.add(value)
                }
            }

            callback(filteredItems) // Pass the filtered items to the callback function
        }
    }


}
