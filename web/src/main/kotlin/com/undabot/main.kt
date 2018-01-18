package com.undabot

import com.undabot.login.LoginComponent
import coroutineContext
import kotlinx.coroutines.experimental.Unconfined
import org.jetbrains.kotlinconf.components.hashRouter
import org.jetbrains.kotlinconf.components.route
import org.jetbrains.kotlinconf.components.switch
import react.dom.render
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    coroutineContext = Unconfined

    window.onload = {
        render(document.getElementById("root")!!) {
            hashRouter {
                switch {
                    route("/", LoginComponent::class, exact = true)
                }
            }
        }
    }
}