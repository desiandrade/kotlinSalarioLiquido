package com.app.calculosalarioliquido.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.app.calculosalarioliquido.R
import com.app.calculosalarioliquido.models.CalculoSalario
import java.math.BigDecimal

class CalculoSalarioLiquido: AppCompatActivity (R.layout.activity_salario_liquido) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configBotaoCalcular()
    }

    fun configBotaoCalcular(){
        val btnCalcular = findViewById<Button>(R.id.button_calcular_salario_liquido)
        btnCalcular.setOnClickListener {
            calcularSalarioLiquido()
        }
    }

    fun calcularSalarioLiquido(){
        var calculoLiquido = BigDecimal.ZERO

        val textSalarioBruto = findViewById<EditText>(R.id.text_salario_bruto)
        val texteDescontosExtras = findViewById<EditText>(R.id.text_descontos_extras)
        val salarioBruto = (textSalarioBruto.text.toString()).toBigDecimal()
        val descontosExtras = (texteDescontosExtras.text.toString()).toBigDecimal()
        val textLiquidoExibido = findViewById<TextView>(R.id.text_resultado_salario_liquido)

        val novoCalculoSalario = CalculoSalario(salarioBruto, descontosExtras)

        if (salarioBruto <= BigDecimal(1045.00)){
            calculoLiquido = salarioBruto - BigDecimal(82.5) - descontosExtras
            textLiquidoExibido.text = "Salário líquido: $calculoLiquido"

        } else if (salarioBruto <= BigDecimal(2089.60)){
            calculoLiquido = salarioBruto - BigDecimal(181.31) - descontosExtras
            if(salarioBruto <= BigDecimal(1903.98)){
                textLiquidoExibido.text = "Salário líquido: $calculoLiquido"
            }
            calculoLiquido -= BigDecimal(142.80)
            textLiquidoExibido.text = "Salário líquido: $calculoLiquido"

        } else if (salarioBruto <= BigDecimal(3134.40)){
            calculoLiquido = salarioBruto - BigDecimal(314.01) - descontosExtras
            if (salarioBruto <= BigDecimal(2826.66)) {
                calculoLiquido -= BigDecimal(142.8)
                textLiquidoExibido.text = "Salário líquido: $calculoLiquido"
            }
            calculoLiquido -= BigDecimal(354.8)
            textLiquidoExibido.text = "Salário líquido: $calculoLiquido"

        } else if (salarioBruto > BigDecimal(3134.40)){
            calculoLiquido = salarioBruto - BigDecimal(411.27) - descontosExtras
            if (salarioBruto <= BigDecimal(4664.68))
                calculoLiquido -= BigDecimal(354.8)
            textLiquidoExibido.text = "Salário líquido: $calculoLiquido"
        }
        calculoLiquido -= BigDecimal(869.36)
        textLiquidoExibido.text = "Salário líquido: $calculoLiquido"

    //https://blog.nubank.com.br/tabela-inss-2021/?utm_source=google&utm_medium=cpc&utm_campaign=14894704957&utm_term=128624557615&utm_word=&utm_content=551305443344&ad_position=&match_type=b&location=20106&device=c&utm_keyword_id=dsa-19959388920&utm_placement=&extension=&geolocation=20106&google_channel=google_gdn&gclid=CjwKCAiAnO2MBhApEiwA8q0HYbN6_ZN6mJLl9N0gvlY4Iy1I7QlFmyS4q9QZ8-BTvHHJ_qO5zUcgRhoCgQQQAvD_BwE
//https://www.contabilizacaofacil.com/calculo-de-salario-liquido.php


    }
}