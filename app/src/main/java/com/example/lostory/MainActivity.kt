package com.example.lostory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lostory.databinding.ActivityMainBinding
import com.example.lostory.ui.alarm.AlarmActivity
import com.example.lostory.ui.dday.DdayActivity
import com.example.lostory.ui.diary.DiaryActivity
import com.example.lostory.ui.mypage.MyPageActivity
import com.example.lostory.ui.objective.ObjectiveActivity
import com.example.lostory.ui.setting.SettingActivity
import com.example.lostory.ui.todo.TodoActivity
import java.util.Objects

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.diaryBtn?.setOnClickListener {
            val intent = Intent(this, DiaryActivity::class.java)
            startActivity(intent)
        }

        binding?.todoBtn?.setOnClickListener {
            val intent = Intent(this, TodoActivity::class.java)
            startActivity(intent)
        }

        binding?.ddayBtn?.setOnClickListener {
            val intent = Intent(this, DdayActivity::class.java)
            startActivity(intent)
        }

        binding?.objectiveBtn?.setOnClickListener {
            val intent = Intent(this, ObjectiveActivity::class.java)
            startActivity(intent)
        }

        binding?.alarmBtn?.setOnClickListener {
            val intent = Intent(this, AlarmActivity::class.java)
            startActivity(intent)
        }

        binding?.settingBtn?.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        binding?.mypageBtn?.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        binding?.logoutBtn?.setOnClickListener {

        }
    }
}