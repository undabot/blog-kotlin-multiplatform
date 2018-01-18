package com.undabot.youoweme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import login.mvp.LoginContract
import login.mvp.LoginCoordinator

class MainActivity : AppCompatActivity(), LoginContract.View {

    private val coordinator by lazy { LoginCoordinator(this) }


    @BindView(R.id.ed_email) lateinit var email: EditText
    @BindView(R.id.ed_password) lateinit var password: EditText
    @BindView(R.id.pb_loading_auth) lateinit var progress: ProgressBar
    @BindView(R.id.bt_login) lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)
    }

    @OnClick(R.id.bt_login)
    fun loginClick() {
        coordinator.authorizationPressed()
    }

    override fun showError(message: String) {
        enableActions(true)
        Toast.makeText(this, "Error: ${message}", Toast.LENGTH_SHORT).show()
    }

    override fun showMainScreen() {
        enableActions(true)
        Toast.makeText(this, "Success 123", Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        enableActions(false)
    }

    override fun hideProgress() {
        enableActions(true)
    }

    private fun enableActions(enable: Boolean) {
        progress.visibility = if (enable) View.GONE else View.VISIBLE
        email.isEnabled = enable
        password.isEnabled = enable
        login.isEnabled = enable
    }
}
