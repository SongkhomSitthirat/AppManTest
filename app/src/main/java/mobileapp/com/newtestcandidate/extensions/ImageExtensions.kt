package mobileapp.com.newtestcandidate.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64


/**
 * Created by book on 5/1/2018 AD.
 */


fun String.toBitmap(): Bitmap {
    val decodedString = Base64.decode(this, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
}





