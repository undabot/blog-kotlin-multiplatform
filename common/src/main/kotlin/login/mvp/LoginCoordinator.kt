package login.mvp

import login.repository.LoginRepository
import login.repository.LoginRepositoryImpl
import login.usecase.Authorize
import ApiService
import models.User

class LoginCoordinator(view: LoginContract.View) : LoginContract.Coordinator {

    private val presenter: LoginContract.Presenter
    private val authorization: Authorize
    private val repository: LoginRepository
    private val apiService: ApiService = ApiService()

    init {
        repository = LoginRepositoryImpl(apiService)
        authorization = Authorize(repository)
        presenter = LoginPresenter(view)
    }

    override fun authorizationPressed() {
        val user = User("", "", "")
        authorization.with(user, presenter)
    }

}