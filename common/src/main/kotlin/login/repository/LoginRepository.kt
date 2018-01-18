package login.repository

import models.Response

interface LoginRepository {

    suspend fun authorization(): Response
}