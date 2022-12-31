package com.example.zad8.data

import android.content.Context
import android.widget.Toast
import com.example.zad8.data.model.LoggedInUser
import com.example.zad8.data.model.RequestModel
import com.example.zad8.data.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String, context: Context): Result<LoggedInUser> {
        try {
            val retrofit = ServiceBuilder.buildService(ApiInterface::class.java)
            val obj = RequestModel(username,password)
            var response = retrofit.sendReq(obj).execute()
            if(response.raw().code() != 200) {
                            throw Exception(response.message())
                        }
            return Result.Success(LoggedInUser("1",username))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}