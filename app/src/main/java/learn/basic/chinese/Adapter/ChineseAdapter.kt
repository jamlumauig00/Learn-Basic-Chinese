package learn.basic.chinese.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import learn.basic.chinese.databinding.CardviewBinding

class ChineseAdapter(var mainlist: Array<String>, val adapterclick: AdapterOnClick, val context: Context) :
    RecyclerView.Adapter<ChineseAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CardviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("DiscouragedApi")
        fun bindIdea(dataCategory: String) {
            binding.title.text = dataCategory
            //binding.icon.resources
            val string =  dataCategory.lowercase().replace(" ", "_") + "_icon"
            val resId = context.resources?.getIdentifier(string, "drawable", context.packageName)
            Log.e("drawableName",resId.toString())
            Log.e("icon", string)

            if (resId != 0) {
                binding.icon.setBackgroundResource(resId!!)
            }
            binding.title.setOnClickListener {
                adapterclick.onclick(adapterPosition,dataCategory)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mainlist[position]
        holder.bindIdea(data)
    }

    override fun getItemCount(): Int {
        return mainlist.size
    }
}
