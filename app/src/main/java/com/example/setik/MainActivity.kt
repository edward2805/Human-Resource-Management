package com.example.setik

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.example.setik.admin.ViewUserActivity
import com.example.setik.databinding.ActivityMainBinding
import com.example.setik.user.ViewDataTugasUser

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var binding : ActivityMainBinding? = null
    private lateinit var profil : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//      menampilkan nama user
        profil = getSharedPreferences("login_session", MODE_PRIVATE)
        binding?.tvuser?.text = profil.getString("nama", null)

//      membuat fungsi tombol keluar
        binding?.imkeluar?.setOnClickListener{
            // menghapus session
            profil.edit().clear().commit()

            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }

        val btn_view : CardView = findViewById(R.id.cvviewUser)
        btn_view.setOnClickListener(this@MainActivity)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.cvviewUser -> {
                    val pindahIntent = Intent(this@MainActivity, ViewDataTugasUser::class.java)
                    startActivity(pindahIntent)
                }
            }
        }
    }
}