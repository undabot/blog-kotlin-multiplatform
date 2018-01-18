package login.mvp

import models.Token

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {
    override fun successfulAuthorization(token: Token) {
        view?.let {
            it.hideProgress()
            view.showMainScreen()
        }
    }

    override fun authorizationInProgress() {
        view?.showProgress()
    }

    override fun failedAuthorization(message: String) {
        view?.let {
            it.hideProgress()
            it.showError(message)
        }
    }
}