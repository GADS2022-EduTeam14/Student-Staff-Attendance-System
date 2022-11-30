package com.andela.eduteam14.android_app.core.ui.auth

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.SplashActivity
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class MobileNumberVerificationActivity : AppCompatActivity() {

    private lateinit var createAccount : Button
    private lateinit var emailET : EditText           //May not be needed
    private lateinit var phoneNumberET : EditText
    private lateinit var passwordET: EditText
    private lateinit var confirmPasswordET: EditText
    private lateinit var dialingCodeET : EditText

    //Focus on Mobile number authentication i.e other fields can be deleted

    private lateinit var email : String
    private lateinit var phoneNumber : String
    private lateinit var password: String
    private lateinit var confirmPassword: String
    private lateinit var dialingCode: String

    private lateinit var auth : FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_number_verification)

        //Start loginFragment
        val registeredUserText = findViewById<TextView>(R.id.RegisteredUser)


        init()
        createAccount.setOnClickListener {
            phoneNumber = phoneNumberET.text.trim().toString()
            dialingCode = dialingCodeET.text.trim().toString()
            email = emailET.toString()
            password = passwordET.toString()
            confirmPassword = confirmPasswordET.toString()

            //check length of dialing code and phone number
            if(email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){

                if((dialingCode.isNotEmpty()) && (dialingCode.length <= 3)){  //dialing code should be from 1 to 3
                    if ((phoneNumber.isNotEmpty()) && (phoneNumber.length == 10)){
                        phoneNumber = "+${dialingCode}${phoneNumber}"

                        val options = PhoneAuthOptions.newBuilder(auth)
                            .setPhoneNumber(phoneNumber)       // Phone number to verify
                            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                            .setActivity(this)                 // Activity (for callback binding)
                            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                            .build()
                        PhoneAuthProvider.verifyPhoneNumber(options)

                    } else{
                        Toast.makeText(this, "Please enter a 10 number",Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "Please enter valid dialing code",Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(this,"Please enter details into all fields",Toast.LENGTH_SHORT).show()
            }

        }

        //Setup OnClick for the TextView
        registeredUserText.setOnClickListener {
            startActivity(Intent(this@MobileNumberVerificationActivity, AuthActivity::class.java))
        }
    }

    private fun init(){
        createAccount = findViewById(R.id.btn_createAcc)
        phoneNumberET = findViewById(R.id.edt_CreateAcc_Number)
        dialingCodeET = findViewById(R.id.edt_DialCode)
        emailET = findViewById(R.id.edt_createAcc_email)
        passwordET = findViewById(R.id.edt_createAcc_password)
        confirmPasswordET = findViewById(R.id.edt_createAcc_confirm_password)
        auth = FirebaseAuth.getInstance()
        //add extra EditTexts for account creation


    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this, "Authenticate Successfully", Toast.LENGTH_SHORT).show()

                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }

    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.
//            Log.d(TAG, "onVerificationCompleted:$credential")
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
//            Log.w(TAG, "onVerificationFailed", e)

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request
                Log.d("TAG", "onVerificationFailed: ${e.toString()}")
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
                Log.w("TAG", "onVerificationFailed: ${e.toString()}")
            }

            // Show a message and update the UI
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.
//            Log.d(TAG, "onCodeSent:$verificationId")
            // Save verification ID and resending token so we can use them later

//            If Code sent then start OTP Activity
            val intent = Intent(this@MobileNumberVerificationActivity, OTPActivity::class.java)
            intent.putExtra("OTP", verificationId)
            intent.putExtra("resendToken", token)
            intent.putExtra("phoneNumber", phoneNumber)
            startActivity(intent)

        }
    }


}

//    override fun onStart() {
//        super.onStart()
//        If there is a user logged in then log him out

//        Code below: //        If there user is signed in then proceed to login

//        if(auth.currentUser != null)
//            startActivity(Intent(this, SplashActivity::class.java))
//    }