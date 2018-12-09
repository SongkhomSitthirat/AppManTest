package mobileapp.com.newtestcandidate.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_data_list.*
import mobileapp.com.newtestcandidate.R
import mobileapp.com.newtestcandidate.adapter.ListAdapter
import mobileapp.com.newtestcandidate.model.JsonListModel
import mobileapp.com.newtestcandidate.utils.JsonHelper
import mobileapp.com.newtestcandidate.utils.Utils
import org.json.JSONObject

class DataListActivity : AppCompatActivity() {

    private lateinit var dataList: List<JsonObject>
    private lateinit var adapterList: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_list)
        init()
    }

    private fun init(){
        adapterList = ListAdapter(this)
        with(recycler_view){
            adapter = adapterList
            layoutManager = LinearLayoutManager(this@DataListActivity)
        }
        getData()
    }

    private fun getData() {
        val jsonString = Utils.loadJSONFromAsset("json.json", this)
        dataList = JsonHelper.toClasss(JSONObject(jsonString), JsonListModel::class.java).dataList
        adapterList.setData(dataList)
    }
}
