package learn.basic.chinese

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        val dataCategory = intent.getStringExtra("data")
        Toast.makeText(this, dataCategory, Toast.LENGTH_SHORT).show()

    }
}