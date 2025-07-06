import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

val MACADRESS = ""
val HTTPADRESS = "http://localhost:5001/trigger"

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Raspi Stream Deck") {
        App()
    }
}

