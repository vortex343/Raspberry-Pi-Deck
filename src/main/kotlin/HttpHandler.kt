import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json()
    }
}

@Serializable
data class ActionPayload(val action: String)

suspend fun sendAction(action: String) {
    val payload = ActionPayload(action)
    val address = "http://localhost:8080/post"//httpbin in docker container
    val response: String = client.post(address) {
        contentType(io.ktor.http.ContentType.Application.Json)
        setBody(payload)
    }.body() // read response body as a string

    println("Response from httpbin:\n$response")
}

