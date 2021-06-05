package com.leclm.ipva2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_site.*

class SiteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site)

        // Habilitando a leitura e execução de códigos JS
        wbvWebIPVA.settings.javaScriptEnabled = true

        // wbvWebIPVA.loadUrl("https://veiculos.fipe.org.br/")

        // Carregando um endereço web para a WebView:
        wbvWebIPVA.loadUrl("https://www.google.com/search?sxsrf=ALeKk0077qd8dDRH_SYJGPRzmq" +
                "NNaJwKeg%3A1601564778751&ei=avB1X66nLdPN5OUPkpe4aA&q=veiculos+fipe+org&oq=vei" +
                "culos+fipe+org&gs_lcp=CgZwc3ktYWIQAzIECCMQJzICCAA6BAgAEEc6BQgAEM0CUJVQWKV5YJJ9" +
                "aABwA3gAgAH9AYgB4hqSAQYwLjI0LjGYAQCgAQGqAQdnd3Mtd2l6yAEIwAEB&sclient=psy-ab&ve" +
                "d=0ahUKEwiuhOPd1ZPsAhXTJrkGHZILDg0Q4dUDCA0&uact=5")

        // Definindo o webview como o cliente padrao
        wbvWebIPVA.webViewClient = WebViewClient()
    }
}