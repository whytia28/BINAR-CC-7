package com.example.binarchapter7.main.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.binarchapter7.R
import com.example.binarchapter7.main.MenuActivity
import kotlinx.android.synthetic.main.fragment_profil.*


class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel
    private var username = MenuActivity.username
    private var email = MenuActivity.email

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.context as MenuActivity).supportActionBar?.title = getString(R.string.profile)

        et_email.setText(email)
        et_username.setText(username)
    }

}