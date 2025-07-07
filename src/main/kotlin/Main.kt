import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

val MACADRESS = ""
val HTTPADRESS = "http://localhost:5001/trigger"

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Raspi Stream Deck") {
        val scope = rememberCoroutineScope()
        scope.launch {
            controllerListener()
        }

        App()
    }
}

