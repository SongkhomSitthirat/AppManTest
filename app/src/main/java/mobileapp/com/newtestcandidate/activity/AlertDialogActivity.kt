package mobileapp.com.newtestcandidate.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import mobileapp.com.newtestcandidate.R


class AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        init()
    }

    private fun init() {
        tv_content.movementMethod = ScrollingMovementMethod()
        bottom_navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_one -> {
                    setText("สวัสดี ขอให้มีความสุข")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_two -> {
                    setText("หิวจัง\nกินอะไรดีนะ")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_three -> {
                    setText("เมื่อวานนี้ไปดูหนัง\nเรื่องอะไรสักอย่าง\nจำไม่ได้")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_four -> {
                    setText(getString(R.string.test_text))
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    private fun setText(text: String) {
        tv_content.text = text
    }


}
