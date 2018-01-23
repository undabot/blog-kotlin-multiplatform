package com.undabot.view

import react.RBuilder
import react.ReactElement
import react.dom.div
import react.dom.img

fun RBuilder.loadingView(): ReactElement? = div(classes = "loading") {
    img(classes = "screen-center progress", src = "spinner.gif") {}
}