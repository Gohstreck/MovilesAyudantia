package unam.mx.login.data

import android.content.Context
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.*
import unam.mx.login.R
import unam.mx.login.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {


    fun login(username: String, password: String, context: Context): Result<LoggedInUser> {

        val queue = Volley.newRequestQueue(context)
            val baseUrl = "https://lamarr.com.mx/webservice2.php";
            val url = "$baseUrl?email=$username&password=$password";
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    Log.d("RespuestaVolley", "login: $response") },
                { print("No funciono") })
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            queue.add(stringRequest)
        return Result.Success(fakeUser)

    }

    fun logout() {
        // TODO: revoke authentication
    }
}


