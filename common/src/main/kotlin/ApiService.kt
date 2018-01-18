import models.Response
import kotlin.coroutines.experimental.suspendCoroutine

const val baseUrl = "https://private-a1d6b-mysample10.apiary-mock.com/testme/"

class ApiService() {

    suspend fun login(): Response = suspendCoroutine { c ->
        httpGET(fullUrl(EndPoints.login), c)
    }

    private fun fullUrl(endpoint: String) = "${baseUrl}${endpoint}"
}

