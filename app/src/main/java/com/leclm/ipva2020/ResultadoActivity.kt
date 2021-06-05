package com.leclm.ipva2020

import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_resultado.*
import java.util.*

class ResultadoActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Recuperando os dados passados por meio da intent
        val estado = intent.getStringExtra("INTENT_ESTADO")
        val valor = intent.getStringExtra("INTENT_VALOR")
        val aliquota = intent.getStringExtra("INTENT_ALIQUOTA")
        val ipva = intent.getStringExtra("INTENT_IPVA")

        if ((estado == " Paraná - PR") || (estado == " Rio Grande do Sul - RS") ||
            (estado == " Santa Catarina - SC")) {
            imvEstado.setImageResource(R.drawable.sul)

        } else if ((estado == " São Paulo - SP") || (estado == " Rio de Janeiro - RJ") ||
                   (estado == " Minas Gerais - MG") || (estado == " Espírito Santo - ES")) {
            imvEstado.setImageResource(R.drawable.sudeste)

        } else if ((estado == " Amazonas - AM") || (estado == " Tocantins - TO") ||
                   (estado == " Pará - PA") ||   (estado == " Acre - AC") || (estado == " Amapá - AP") ||
                   (estado == " Rondônia - RO") || (estado == " Roraima - RR")) {
            imvEstado.setImageResource(R.drawable.norte)

        } else if ((estado == " Mato Grosso - MT") || (estado == " Distrito Federal - DF") ||
                   (estado == " Mato Grosso do Sul - MS") || (estado == " Goiás - GO")) {
            imvEstado.setImageResource(R.drawable.centrooeste)

        } else {
            imvEstado.setImageResource(R.drawable.nordeste)
        }

        val nf = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

        txvPercentual.text = "A alíquota para o$estado é de $aliquota%"
        if (ipva != null && valor != null) {
            txvValor.text = "Para o veículo de R$${nf.format(valor.toDouble())} o IPVA é de R$${nf.format(ipva.toDouble())}"
        }
    }
}
