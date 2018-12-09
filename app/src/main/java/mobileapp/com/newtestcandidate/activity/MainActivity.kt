package mobileapp.com.newtestcandidate.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mobileapp.com.newtestcandidate.R
import mobileapp.com.newtestcandidate.adapter.MenuAdapter

class MainActivity : AppCompatActivity() {

    private val menuList: List<String> by lazy { listOf("json", "alert", "image", "camera") }
    private lateinit var adapterList: MenuAdapter

    companion object {
        private const val REQUEST_CODE_PERMISSION_CAMERA = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        adapterList = MenuAdapter(this, onClick)

        with(recycler_view) {
            adapter = adapterList
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        getData()
    }


    private fun getData() {
        adapterList.setData(menuList)
    }

    private val onClick: (position: Int) -> Unit = { position ->
        when (position) {
            0 -> {
                startPage(DataListActivity::class.java)
            }
            1 -> {
                startPage(AlertDialogActivity::class.java)
            }
            2 -> {
                startPage(ImageActivity::class.java)
            }
            3 -> {
                checkPermissionCamera()
            }
        }

    }

    private fun startPage(act: Class<*>) {
        val intentAct = Intent(this, act)
        startActivity(intentAct)
    }

    private fun checkPermissionCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQUEST_CODE_PERMISSION_CAMERA)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE_PERMISSION_CAMERA -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)
                }
            }
        }
    }
}
