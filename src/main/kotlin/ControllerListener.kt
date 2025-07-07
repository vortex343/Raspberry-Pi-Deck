import kotlinx.coroutines.delay
import net.java.games.input.Controller
import net.java.games.input.ControllerEnvironment

suspend fun controllerListener() {
    val controllers = ControllerEnvironment.getDefaultEnvironment().controllers

    val gamepad = controllers.firstOrNull { it.type == Controller.Type.GAMEPAD || it.type == Controller.Type.STICK }

    if (gamepad == null) {
        println("No gamepad detected.")
        return
    }

    println("Using controller: ${gamepad.name}")

    while (true) {
        gamepad.poll()

        val components = gamepad.components
        for (component in components) {
            val value = component.pollData

            // Skip inactive or idle
            if (value != 0f) {
                val name = component.name
                println("Input: $name - Value: $value")
            }
        }

        delay(100) // Poll rate
    }
}
