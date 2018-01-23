package com.undabot.login

import com.undabot.BaseState
import com.undabot.view.errorView
import com.undabot.view.loadingView
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import login.mvp.LoginContract
import login.mvp.LoginCoordinator
import react.*
import react.dom.*
import kotlin.browser.window

class LoginComponent : RComponent<RProps, LoginComponentState>(), LoginContract.View {

    private val coordinator by lazy { LoginCoordinator(this) }

    override fun RBuilder.render(): ReactElement? = when {
        state.loading == true -> loadingView()
        state.error != null -> errorView(state.error!!)
        else -> {
            loginView()
        }
    }

    private fun RBuilder.loginView(): ReactElement {
        return div {
            h1 { +"Login" }
            form {
                input(type = InputType.email) { setProp("placeholder", "Email") }
                input(type = InputType.password) { setProp("placeholder", "Password") }
                button() {
                    attrs {
                        onClickFunction = fun(_) {
                            coordinator.authorizationPressed()
                        }
                    }
                    +"Send"
                }
            }
        }
    }

    override fun showError(message: String) {
        setState { error = message }
    }

    override fun showMainScreen() {

    }

    override fun showProgress() {
        setState { loading = true }
    }

    override fun hideProgress() {
        setState { loading = false }
    }
}

external interface LoginComponentState : BaseState