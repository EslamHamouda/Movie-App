package com.example.movieapp.auth.register.ui

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
import com.example.movieapp.databinding.FragmentRegisterBinding
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvLogin.setOnClickListener { goLogin() }
        binding.btnRegister.setOnClickListener { register() }
    }

    private fun register() {
        val username = binding.etFullName.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val mobile = binding.etPhoneNumber.text.toString().trim()

        val jsonObject = JSONObject()
        jsonObject.put("userName", username)
        jsonObject.put("password", password)
        jsonObject.put("email", email)
        jsonObject.put("mobile", mobile)
        val jsonObjectString = jsonObject.toString()
        val requestBody = RequestBody.create(MediaType.parse("application/json"), jsonObjectString)
        ApiInterface.create().register(requestBody).enqueue(object : Callback<UserModel?> {
            override fun onResponse(call: Call<UserModel?>, response: Response<UserModel?>) {
                if (response.code() == 200) {
                    goLogin()
                } else {
                    Log.d("LOL", "onResponse: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<UserModel?>, t: Throwable) {
                Log.d("LOL", "onFailure: ${t.message}")
            }
        })

    }

    private fun goLogin() {
        findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
    }

}