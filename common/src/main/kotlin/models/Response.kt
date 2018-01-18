package models

sealed class Response {

    data class Success(val body: String) : Response()
    data class Error(val status: Int, val message: String) : Response()
    object Timeout : Response()
}