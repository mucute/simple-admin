import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mucute.simple.admin.network.Api
import com.mucute.simple.admin.network.entity.User
import com.mucute.simple.admin.screen.MainScreen
import com.mucute.simple.admin.theme.SimpleTheme
import retrofit2.Call
import retrofit2.Response

@Composable
@Preview
fun App() {
    SimpleTheme {
        MainScreen()
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Simple后台管理系统") {
        App()
    }

}

fun <T> Call<T>.success(result: (T) -> Unit) {
    enqueue(object : retrofit2.Callback<T> {
        override fun onResponse(p0: Call<T>, p1: Response<T>) {
            result(p1.body() as T)
        }

        override fun onFailure(p0: Call<T>, p1: Throwable) {
            println("程序异常")
            p1.printStackTrace()
        }
    }
    )
}