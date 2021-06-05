package com.leclm.ipva2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imvHelp.setOnClickListener {
            val myIntent = Intent(this, SiteActivity::class.java)
            startActivity(myIntent)
        }

        // Criar lista de opções para o Spinner
        val listaEstados = arrayListOf(
            " Selecione o Estado",
            " Acre - AC",
            " Alagoas -  AL",
            " Amapá - AP",
            " Amazonas - AM",
            " Bahia - BA",
            " Ceará - CE",
            " Distrito Federal - DF",
            " Espírito Santo - ES",
            " Goiás - GO",
            " Maranhão - MA",
            " Mato Grosso - MT",
            " Mato Grosso do Sul - MS",
            " Minas Gerais - MG",
            " Pará - PA",
            " Paraíba - PB",
            " Paraná - PR",
            " Pernambuco - PE",
            " Piauí - PI",
            " Rio de Janeiro - RJ",
            " Rio Grande do Norte - RN",
            " Rio Grande do Sul - RS",
            " Rondônia - RO",
            " Roraima - RR",
            " Santa Catarina - SC",
            " São Paulo - SP",
            " Sergipe - SE",
            " Tocantins - TO")

        // Criar um adaptador para o spinner: tela em que o adapter vai ser exibido (this), o tipo de adaptador e a lista
        val estadoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listaEstados
        )

        // Inserir o adapter no spinner
        spnEstados.adapter = estadoAdapter

        // Atribuir o listener ao btnCalcular
        btnCalcular.setOnClickListener {

            val valor = edtValor.text.toString().trim()
            val estado = spnEstados.selectedItem.toString()

            // Validação dos campos
            when {
                valor.isEmpty() -> {
                    // Mostrando toast ao usuario
                    Toast.makeText(this, "Digite o valor do veículo!", Toast.LENGTH_LONG).show()
                }
                estado == listaEstados[0] -> {
                    Toast.makeText(this, "Selecione o Estado!", Toast.LENGTH_LONG).show()
                }
                else -> {
                    var aliquota: Double

                    if ((estado == " Santa Catarina - SC") || (estado == " Espírito Santo - ES") ||
                        (estado == " Acre - AC") || (estado == " Tocantins - TO") ||
                        (estado == " Sergipe - SE") || (estado == " Paraíba - PB") ) {
                        aliquota = 2.0
                    } else if ((estado == " Rio Grande do Sul - RS") || (estado == " São Paulo - SP") ||
                        (estado == " Amapá - AP") || (estado == " Amazonas - AM") ||
                        (estado == " Roraima - RR") || (estado == " Rondônia - RO") ||
                        (estado == " Mato Grosso - MT") || (estado == " Distrito Federal - DF")) {
                        aliquota = 3.0
                    } else if (estado == " Paraná - PR") {
                        aliquota = 3.5
                    } else if ((estado == " Rio de Janeiro - RJ") || (estado == " Minas Gerais - MG")) {
                        aliquota = 4.0
                    } else  {
                        aliquota = 2.5
                    }

                    // Cálculo do IPVA
                    val ipva = (valor.toDouble() * aliquota) / 100

                    // Mudar para a tela de resultado
                    val myIntent = Intent(this, ResultadoActivity::class.java)

                    // Passando os dados para a prox tela (Resultado) atraves da intent
                    myIntent.putExtra("INTENT_VALOR", valor)
                    myIntent.putExtra("INTENT_ESTADO", estado)
                    myIntent.putExtra("INTENT_ALIQUOTA", aliquota.toString())
                    myIntent.putExtra("INTENT_IPVA", ipva.toString())

                    //Iniciar a MainActivity através da Intent
                    startActivity(myIntent)
                }
            }
        }
    }
}