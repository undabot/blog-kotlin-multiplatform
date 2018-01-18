package login.usecase

import kotlinx.serialization.json.JSON
import launchCancellable
import login.repository.LoginRepository
import models.Response
import models.Token
import models.User

class Authorize(private val repository: LoginRepository) {

    fun with(user: User, presenter: HandleAuthorization) {
        presenter.authorizationInProgress()
        launchCancellable({
            val response = repository.authorization()
            when (response) {
                is Response.Success -> presenter.successfulAuthorization(JSON.parse(response.body))
                is Response.Error -> presenter.failedAuthorization(response.message)
                Response.Timeout -> presenter.failedAuthorization("Time out message")
            }
        })
    }

    interface HandleAuthorization {
        fun authorizationInProgress()
        fun successfulAuthorization(token: Token)
        fun failedAuthorization(message: String)
    }
}