package com.undabot.view

import react.RBuilder
import react.ReactElement
import react.dom.div
import react.dom.h3

fun RBuilder.errorView(error: String): ReactElement? = div(classes = "error") {
    h3(classes = "center-on-screen") {
        +error
    }
}