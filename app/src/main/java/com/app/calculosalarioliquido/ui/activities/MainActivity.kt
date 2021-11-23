package com.app.calculosalarioliquido.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.app.calculosalarioliquido.R
import com.app.calculosalarioliquido.models.CalculoSalario

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        configBotaoSalarioLiquido()
    }

    fun configBotaoSalarioLiquido (){
        val btnSalarioLiquido = findViewById<Button>(R.id.button_salario_liquido)
        btnSalarioLiquido.setOnClickListener {
            val intent = Intent(this, CalculoSalarioLiquido::class.java)
            startActivity(intent)
        }
    }

//    fun configBotaoDecimoTerceiro(){
//        val btnDecimoTerceiro = findViewById<Button>(R.id.button_decimo_terceiro)
//        btnDecimoTerceiro.setOnClickListener {
//            val intent = Intent(this,)
//        }
//    }
}