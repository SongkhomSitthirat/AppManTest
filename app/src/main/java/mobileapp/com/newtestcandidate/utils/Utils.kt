package mobileapp.com.newtestcandidate.utils

import android.content.Context
import java.io.IOException

object Utils {
    fun loadJSONFromAsset(name: String, context: Context): String? {
        val json: String?
        try {
            val input = context.assets.open(name)
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

}