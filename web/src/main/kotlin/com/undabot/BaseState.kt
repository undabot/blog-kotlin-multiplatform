package com.undabot

external interface  BaseState: react.RState {
    var loading: Boolean
    var error: String?
}