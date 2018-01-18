package com.undabot

external interface  BaseState: react.RState {
    var error: Throwable?
}