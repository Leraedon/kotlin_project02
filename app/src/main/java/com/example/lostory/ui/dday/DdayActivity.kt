package com.example.lostory.ui.dday

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lostory.R
import com.example.lostory.data.model.Dday
import com.example.lostory.databinding.ActivityDdayBinding

class DdayActivity : AppCompatActivity() {
    var binding: ActivityDdayBinding? = null
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDdayBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val datas: ArrayList<Dday> = arrayListOf()
        val testdata = Dday("a", "b", "2024-01-23", 1)

        datas.add(testdata)

        binding?.ddayRv!!.layoutManager = LinearLayoutManager(this)
        binding?.ddayRv!!.adapter = DdayAdapter(datas)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}