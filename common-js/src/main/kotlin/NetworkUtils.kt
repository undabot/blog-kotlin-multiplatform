import models.Response
import org.w3c.xhr.XMLHttpRequest
import kotlin.coroutines.experimental.Continuation

object Status {
    val success = 200
    val redirection = 300
    val clientError = 400
    val serverError = 500
}

object Methods {
    val get = "GET"
    val post = "POST"
}

actual fun httpGET(url: String, continuation: Continuation<Response>) {
    val request = XMLHttpRequest()
    request.handleResponse(continuation)
    request.open(Methods.get, url)
    request.send()
}

actual fun httpPOST(url: String, body: String, continuation: Continuation<Response>) {
    val request = XMLHttpRequest()
    request.handleResponse(continuation)
    request.open(Methods.get, url)
    request.setRequestHeader("Content-Type", "application/json")
    request.send(body)
}

private fun XMLHttpRequest.handleResponse(continuation: Continuation<Response>) {
    this.onreadystatechange = {
        if (this.isDone()) {
            when (this.success()) {
                true -> continuation.resume(Response.Success(this.response as String))
                false -> continuation.resume(Response.Error(this.status.toInt(), this.response as String))
            }
        }
        null
    }
    this.ontimeout = {
        continuation.resume(Response.Error(this.status.toInt(), this.response as String))
    }
}

private fun XMLHttpRequest.isDone() = this.readyState == XMLHttpRequest.DONE

private fun XMLHttpRequest.success() = when (this.isDone()) {
    true -> this.status >= Status.success || this.status < Status.redirection
    else -> false
}





