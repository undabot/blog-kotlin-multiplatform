package login.mvp

import login.usecase.Authorize

interface LoginContract {

    interface View {
        fun showError(message: String)
        fun showMainScreen()
        fun showProgress()
        fun hideProgress()
    }

    interface Coordinator {
        fun authorizationPressed()
    }

    interface Presenter : Authorize.HandleAuthorization
}