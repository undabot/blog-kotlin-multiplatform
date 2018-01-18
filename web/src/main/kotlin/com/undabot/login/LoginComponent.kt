package com.undabot.login

import com.undabot.BaseState
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import login.mvp.LoginContract
import login.mvp.LoginCoordinator
import react.*
import react.dom.*

class LoginComponent : RComponent<RProps, LoginComponentState>(), LoginContract.View {

    private val coordinator by lazy { LoginCoordinator(this) }

    override fun RBuilder.render(): ReactElement? {
        return div {
            h1 { +"Login please" }
            form {
                +"Email:${input(type = InputType.email) {}}"
                +"Pasword:${input(type = InputType.password) {}}"
            }
            button(classes = "mdc-button mdc-button--raised") {
                attrs {
                    onClickFunction = fun(_) {
                        coordinator.authorizationPressed()
                    }
                }
                +"Send"
            }
        }
    }

    override fun showError(message: String) {
    }

    override fun showMainScreen() {
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }
}

external interface LoginComponentState : BaseState {
}