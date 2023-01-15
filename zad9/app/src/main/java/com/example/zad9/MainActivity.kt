package com.example.zad9

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.stripe.android.ApiResultCallback
import com.stripe.android.PaymentConfiguration
import com.stripe.android.Stripe
import com.stripe.android.createCardToken
import com.stripe.android.model.*
import com.stripe.android.view.CardInputWidget
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    private val backendUrl = "https://android-shop.herokuapp.com/"
    private val httpClient = OkHttpClient()
    private lateinit var stripe: Stripe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PaymentConfiguration.init(applicationContext, "pk_test_51MQYlWIERlrwVOipof77XQb7J2sHz3PSqs3q8Bu1CIET8mFUaqd0VftQrUhXkpYJmxcJTdfik6QGieEtZYXucdg400b3AsHISc") // Get your key here: https://stripe.com/docs/keys#obtain-api-keys

        // Hook up the pay button to the card widget and Stripe instance
        val payButton: Button = findViewById(R.id.payButton)
        val weakActivity = WeakReference<Activity>(this@MainActivity)
        payButton.setOnClickListener {
            // Get the card details from the card widget
            val cardInputWidget =
                findViewById<CardInputWidget>(R.id.cardInputWidget)
            cardInputWidget.cardParams?.let { card ->
                // Create a Stripe token from the card details
                stripe = Stripe(
                    applicationContext,
                    PaymentConfiguration.getInstance(applicationContext).publishableKey
                )
                stripe.createCardToken(card,null,null, object: ApiResultCallback<Token> {
                    override fun onSuccess(result: Token) {
                        // Send the Token identifier to the server
                        val mediaType = "application/json; charset=utf-8".toMediaType()
                        val json = """
                            {
                                "currency":"usd",
                                "stripeToken": "${result.id}"
                            }
                            """
                        val body = json.toRequestBody(mediaType)
                        val request = Request.Builder()
                            .url(backendUrl + "pay/")
                            .post(body)
                            .build()
                        httpClient.newCall(request)
                            .enqueue(object: Callback {
                                override fun onFailure(call: Call, e: IOException) {
                                    displayAlert(weakActivity.get(), "Failed to decode response from server", "Error: $e")
                                }

                                override fun onResponse(call: Call, response: Response) {
                                    if (!response.isSuccessful) {
                                        displayAlert(weakActivity.get(), "Failed to decode response from server", "Error: ${response}")
                                    } else {
                                        val responseData = response.body?.string()
                                        var responseJSON = JSONObject(responseData)
                                        val error = responseJSON.optString("error", null)
                                        if (error != null) {
                                            displayAlert(weakActivity.get(), "Payment failed", error)
                                        } else {
                                            displayAlert(weakActivity.get(), "Success", "Payment succeeded!", true)
                                        }
                                    }
                                }
                            })
                    }

                    override fun onError(e: java.lang.Exception) {
                        displayAlert(weakActivity.get(), "Error", e.localizedMessage)
                    }
                })
            }
        }
    }

    private fun displayAlert(activity: Activity?, title: String, message: String, restartDemo: Boolean = false) {
        if (activity == null) {
            return
        }
        runOnUiThread {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle(title)
            builder.setMessage(message)
            if (restartDemo) {
                builder.setPositiveButton("Restart demo") { _, _ ->
                    val cardInputWidget =
                        findViewById<CardInputWidget>(R.id.cardInputWidget)
                    cardInputWidget.clear()
                }
            }
            else {
                builder.setPositiveButton("Ok", null)
            }
            val dialog = builder.create()
            dialog.show()
        }
    }
}