package com.example.lostory.ui.dday

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.lostory.data.model.Dday
import com.example.lostory.databinding.ItemDdayBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar

class DdayViewHolder(val binding: ItemDdayBinding): RecyclerView.ViewHolder(binding.root) {
}

@RequiresApi(Build.VERSION_CODES.O)
class DdayAdapter(val datas: ArrayList<Dday>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")

    val localDate: LocalDate = LocalDate.now()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        DdayViewHolder(ItemDdayBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as DdayViewHolder).binding
        binding.itemTitle.text = datas[position].title
        binding.itemEndDate.text = datas[position].endDate

        val startDate = dateFormat.parse(localDate.toString())?.time
        val endDate = datas[position].endDate?.let { dateFormat.parse(it).time }
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time.time
        val dday = (endDate?.minus(today)?.div((24 * 60 * 60 * 1000)))

        binding.itemCountdown.text = "D-${dday.toString()}"
    }

}