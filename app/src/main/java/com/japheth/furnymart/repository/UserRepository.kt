package com.japheth.furnymart.repository

import com.japheth.furnymart.data.UserDao
import com.japheth.furnymart.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}