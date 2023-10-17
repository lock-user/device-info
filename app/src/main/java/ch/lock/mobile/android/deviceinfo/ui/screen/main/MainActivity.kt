package ch.lock.mobile.android.deviceinfo.ui.screen.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ch.lock.mobile.android.deviceinfo.ui.base.activity.BaseActivity
import ch.lock.mobile.android.deviceinfo.ui.theme.DeviceInfoTheme

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

}

@Composable
private fun MainContent() {
    Text(text = "Compose")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DeviceInfoTheme {
        MainContent()
    }
}