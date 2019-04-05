package com.example.espressologintest

class Login {

    fun doLogin(login: String, password: String): Boolean {
        return login == LOGIN && password == PASSWORD
    }

    companion object {
        const val LOGIN = "Warren"
        const val PASSWORD = "1234"
    }
}