package com.jhonny.a20210510_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = getIntent()
        val website:String? = intent.getStringExtra("website")
        if (website != null){
            webv.settings.javaScriptEnabled = true
            webv.setWebViewClient(WebViewClient())
            webv.loadUrl(website)
        }

        btnBack.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                finish()
            }
        })
    }
    override fun onBackPressed(){
        if (webv.canGoBack()){
            webv.goBack()
        }
        else{
            finish()
        }
    }
}