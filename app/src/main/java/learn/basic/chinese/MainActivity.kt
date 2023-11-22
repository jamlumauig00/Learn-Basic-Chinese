package learn.basic.chinese

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import com.jam.cookingina.Database.ChineseDatabaseCopier
import learn.basic.chinese.Adapter.AdapterOnClick
import learn.basic.chinese.Adapter.ChineseAdapter
import learn.basic.chinese.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterOnClick {

    private lateinit var binding: ActivityMainBinding
    private var arraylist: Array<String> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        ChineseDatabaseCopier.copyChineseDatabaseFromAssets(this)
        val res: Resources = resources
        arraylist = res.getStringArray(R.array.Categories)

        val gridLayoutManager = GridLayoutManager(this, 2) // 2 columns in the grid
        binding.chineseRview.layoutManager = gridLayoutManager

        val adapter = ChineseAdapter(arraylist,this, this)
        binding.chineseRview.adapter = adapter

       /* ChineseClassGetData(this).getData("Greetings", this) {
            // Handle the filtered items here
            // You can access filteredItems inside this block.
            Log.e("Categories", it.toString())
            binding.chineseRview
        }*/
    }

    override fun onclick(position: Int, data: String) {
        //Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, CategoriesActivity::class.java).putExtra("data",data))
    }
}