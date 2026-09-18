package com.amaurypm.counterapp

import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amaurypm.counterapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineExceptionHandler

class MainActivity : AppCompatActivity() {

    var counter = 0
    //private lateinit var tvCounter: TextView
    //private lateinit var btnCount: Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Instanciamos el objecto con view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Pinta en pantalla el layout, pero con view binding
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //tvCounter = findViewById<TextView>(R.id.tvCounter)
        //btnCount = findViewById<Button>(R.id.btnCount)

        //tvCounter.text = "Hola desde Kotlin"

        binding.apply {
            btnCount.setOnClickListener {
                counter++
                tvCounter.text = "$counter"
            }

            btnReset.setOnClickListener {
                counter = 0
                tvCounter.text = getString(R.string.initial_count)
            }
        }



    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return when(keyCode){
            KeyEvent.KEYCODE_VOLUME_UP -> {
                counter++
                binding.tvCounter.text = "$counter"
                true
            }

            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                counter = 0
                binding.tvCounter.text = getString(R.string.initial_count)
                true
            }
            else -> { super.onKeyDown(keyCode, event) }
        }
    }

}