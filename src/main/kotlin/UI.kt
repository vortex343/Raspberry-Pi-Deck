import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    val actions = arrayOf(
        arrayOf("boot", "shutdown"),
        arrayOf("start", "stop")
    )
    val scope = rememberCoroutineScope()

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            actions.forEach { actions ->
                Row (
                    modifier = Modifier.padding(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    actions.forEach { action ->
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .background(Color.LightGray)
                                .size(100.dp, 100.dp)
                                .clickable {
                                    scope.launch {
                                        handleAction(action)
                                    }
                                }) {
                            Text(action)
                        }
                    }
                }
            }
        }
    }
}