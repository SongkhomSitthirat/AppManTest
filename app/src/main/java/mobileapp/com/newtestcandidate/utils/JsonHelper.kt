package mobileapp.com.newtestcandidate.utils

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject



object JsonHelper {
    private val gson = Gson()
    private val parser: JsonParser by lazy { JsonParser() }


    fun toJson(src: Any?): String{
        return gson.toJson(src)
    }

    fun <T : Any?> toClasss(jsonString: String, className: Class<T>): T{
        return gson.fromJson(jsonString, className)
    }

    fun <T : Any?> toClasss(src: JSONObject, className: Class<T>): T{
        return gson.fromJson(src.toString(), className)
    }

    fun toObj(src: String): JsonObject {
        return parser.parse(src) as JsonObject
    }


    fun <T : Any?> JSONObject.toClass(toClass: Class<T>): T {
        return JsonHelper.toClasss(this, toClass)
    }


    fun <T: Any?> T.toJsonString(): String{
        return JsonHelper.toJson(this)
    }

}
