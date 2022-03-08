package com.banregio.talentodroid.ui.activitys

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.banregio.talentodroid.databinding.ActivitySignBinding
import java.io.File
import java.io.FileOutputStream

class SignActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAndConf()
    }

    private fun initAndConf(){
        binding.tvClearSign.setOnClickListener{
            binding.gestureOverlayView.cancelClearAnimation()
            binding.gestureOverlayView.clear(true)
        }

        binding.btnSignCancel.setOnClickListener{
            finish()
        }

        binding.btnSignSave.setOnClickListener{
            saveSign()
        }

    }

    private fun saveSign(){
        val cw = ContextWrapper(applicationContext)
        val directory = cw.getDir("firmas", Context.MODE_PRIVATE)
        val myPath = File(directory, "firma.png")
        val fos = FileOutputStream(myPath)
        val map = binding.gestureOverlayView.gesture.toBitmap(480, 360, 8, Color.BLACK)
        map.compress(Bitmap.CompressFormat.PNG, 100, fos)
        fos.close()
        Toast.makeText(applicationContext, "Salvada", Toast.LENGTH_SHORT).show()
        finish()
    }

}