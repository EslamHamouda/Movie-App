package com.example.movieapp.auth.login.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.auth.data.ApiInterface
import com.example.movieapp.auth.data.UserModel
import com.example.movieapp.databinding.FragmentLoginBinding
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvRegister.setOnClickListener { goRegister() }
        binding.btnLogin.setOnClickListener { login() }
    }

    private fun goRegister() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
    }

    private fun login() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.edPassword.text.toString().trim()

        val params = HashMap<String?, String?>()
        params["email"] = email
        params["password"] = password

        ApiInterface.create().login(params).enqueue(object : Callback<UserModel?> {
            override fun onResponse(call: Call<UserModel?>, response: Response<UserModel?>) {
                if (response.body() != null) {
                    UserModel.currentUser.username = response.body()!!.username
                    UserModel.currentUser.email = response.body()!!.email
                    UserModel.currentUser.mobile = response.body()!!.mobile
                    UserModel.currentUser.userId = response.body()!!.userId
                    UserModel.currentUser.token = response.body()!!.token

                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeNavigation())
                }
            }

            override fun onFailure(call: Call<UserModel?>, t: Throwable) {

            }
        })

    }


}