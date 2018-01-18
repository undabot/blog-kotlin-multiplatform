package login.repository

import ApiService

class LoginRepositoryImpl(private val apiService: ApiService) : LoginRepository {

    suspend override fun authorization() = apiService.login()

}