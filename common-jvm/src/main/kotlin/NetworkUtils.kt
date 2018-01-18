import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import models.Response
import kotlin.coroutines.experimental.Continuation

actual fun httpGET(url: String, continuation: Continuation<Response>) {
    url.httpGet().responseString { request, response, result ->
        when (result) {
            is Result.Failure -> continuation.resume(Response.Error(response.statusCode, result.getAs() ?: ""))
            is Result.Success -> continuation.resume(Response.Success(result.getAs() ?: ""))
        }
    }
}

actual fun httpPOST(url: String, body: String, continuation: Continuation<Response>) {
    TODO("http post jvm not implemented")
}