package com.example.loginwithgoogle

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.loginfire.MainActivity
import com.example.loginfire.R
import com.example.loginfire.googleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn


class ProfilePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val personName = acct.displayName
            val personGivenName = acct.givenName
            val personFamilyName = acct.familyName
            val personEmail = acct.email
            val personId = acct.id
            val personPhoto: Uri = acct.photoUrl
            val name = findViewById<TextView>(R.id.name)
            name.setText("${personName}")
            val email = findViewById<TextView>(R.id.email)
            email.setText("${personEmail}")
            val ProfilePhoto = findViewById<ImageView>(R.id.image)
            val image = acct.photoUrl.toString()
            Glide.with(this).load(image).into(ProfilePhoto)

        }
        val signOut = findViewById<Button>(R.id.button_sign_out)
        signOut.setOnClickListener { signOut() }
    }

    private fun signOut() {
        startActivity(Intent(this, MainActivity::class.java))
        Toast.makeText(this,"You signed out successfully",Toast.LENGTH_SHORT)
    }
}
