package com.example.cameraapp

import android.app.Application
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.exifinterface.media.ExifInterface
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class CameraViewModel(application: Application): AndroidViewModel(application) {

    private var _bitmap = MutableLiveData<Bitmap>()
    var bitmap = _bitmap
    private var _imageCapture = MutableLiveData<ImageCapture>()
    var imageCapture = _imageCapture

    var cameraSelector = MutableLiveData<CameraSelector>(CameraSelector.DEFAULT_BACK_CAMERA)
    var capturedUri =  MutableLiveData<Uri>()

    fun setCapturedUri(u: Uri){
        capturedUri.value = u
    }

    fun swapCamera(){
        if (cameraSelector.value == CameraSelector.DEFAULT_BACK_CAMERA){
            cameraSelector.value = CameraSelector.DEFAULT_FRONT_CAMERA
        } else {
            cameraSelector.value = CameraSelector.DEFAULT_BACK_CAMERA
        }
    }
}