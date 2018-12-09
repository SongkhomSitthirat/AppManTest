package mobileapp.com.newtestcandidate

import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import mobileapp.com.newtestcandidate.utils.Utils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class ExampleUnitTest {

    lateinit var ctx: Context

    @Before
    fun setup() {
        ctx = mock()

    }

    @Test
    fun context() {
        Assert.assertNotNull(ctx)
    }


    @Test
    fun testJson() {
        Assert.assertNotNull(Utils.loadJSONFromAsset("json.json", RuntimeEnvironment.application.applicationContext))
        Assert.assertNull(Utils.loadJSONFromAsset("", RuntimeEnvironment.application.applicationContext))
    }

}
