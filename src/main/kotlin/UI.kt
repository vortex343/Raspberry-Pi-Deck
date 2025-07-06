import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    val actions = arrayOf(
        arrayOf("media_back", "media_play", "media_forward"),
        arrayOf("rgb_up", "rgb_down"),
        arrayOf("boot", "leave"),
        )

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            actions.forEach { actions ->
                Row (
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    actions.forEach { action ->
                        ActionBox(action)
                    }
                }
            }
        }
    }
}

@Composable
fun ActionBox(action: String) {
    val scope = rememberCoroutineScope()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp, 100.dp)
            .clickable {
                scope.launch {
                    handleAction(action)
                }
            }) {
        val resourcePath = "icons/$action.png"

        val resourceStream = object {}.javaClass.getResourceAsStream(resourcePath)
        val exists = resourceStream != null

        if (exists) {
            val painter: Painter = painterResource(resourcePath)
            Image(
                painter = painter,
                contentDescription = action,
                modifier = Modifier.fillMaxSize()
            )
        }else{
            Text(action)
        }

    }
}