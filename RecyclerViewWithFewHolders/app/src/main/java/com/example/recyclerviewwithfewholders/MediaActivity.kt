package com.example.recyclerviewwithfewholders

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.example.recyclerviewwithfewholders.databinding.ActivityMediaBinding
import com.example.recyclerviewwithfewholders.models.Media

class MediaActivity : AppCompatActivity() {

    private lateinit var mediaBinding: ActivityMediaBinding
    private var imageURI: Uri? = null
    private lateinit var mediaTitle: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaBinding = ActivityMediaBinding.inflate(layoutInflater)
        setContentView(mediaBinding.root)

        mediaBinding.mediaImage.setOnClickListener {
            openGallery()
        }
        mediaBinding.addMediaBtn.setOnClickListener {
            openMainActivity()
        }
    }

    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
    }

    private fun openMainActivity() {
        mediaTitle = mediaBinding.imageTitle.text.toString()
        val mediaObject = Media(imageURI, mediaTitle)
        Log.e("Media", mediaObject.mediaTitle + "----- " + mediaObject.mediaImg)
        val mainIntent = Intent(this, MainActivity::class.java)
        mainIntent.putExtra("Media", mediaObject)
        setResult(MAIN_REQUEST_CODE, mainIntent)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == GALLERY_REQUEST_CODE) {
            imageURI = data?.data
            mediaBinding.mediaImage.setImageURI(imageURI)
        }
    }

    companion object {
        const val GALLERY_REQUEST_CODE = 1
        const val MAIN_REQUEST_CODE = 2
    }
}