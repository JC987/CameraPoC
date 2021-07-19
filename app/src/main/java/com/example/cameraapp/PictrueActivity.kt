package com.example.cameraapp

import android.content.Intent
import android.media.ExifInterface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.imageview.ShapeableImageView

class PictrueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pictrue)
        val iv = findViewById<ShapeableImageView>(R.id.iv)
        val previewRequest =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val list = it.data
                    val uri = it.data?.getStringExtra("uri")

                    val fileUri = Uri.parse(uri)


                    iv.setImageURI(fileUri)

                    // do whatever with the data in the callback
                }
            }

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            previewRequest.launch(intent)
        }
    }
}