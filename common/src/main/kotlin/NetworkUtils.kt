import models.Response
import kotlin.coroutines.experimental.Continuation

expect fun httpGET(url: String, continuation: Continuation<Response>)
expect fun httpPOST(url: String, body: String, continuation: Continuation<Response>)
