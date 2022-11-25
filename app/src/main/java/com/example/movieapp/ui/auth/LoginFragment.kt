package com.example.movieapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.movieapp.MainActivity
import com.example.movieapp.ui.viewmodel.AuthViewModel
import com.example.movieapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    val viewModel: AuthViewModel by viewModels()

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

        binding.btnLogin.setOnClickListener { viewModel.login(getLoginData()) }

        lifecycleScope.launch {
            viewModel.loginResponse.observe(viewLifecycleOwner) {
                if (it.isSuccessful){
                    Toast.makeText(requireContext(),"Login success", Toast.LENGTH_SHORT).show()
                    requireActivity().getSharedPreferences("uId",0).edit().putInt("id",it.body()!!.userId!!).apply()
                    startActivity(Intent(requireActivity(),MainActivity::class.java))
                    requireActivity().finish()
                }
                else{
                    Toast.makeText(requireContext(),"Login failed ${it.code()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun getLoginData():Map<String,String>{
        val body= mutableMapOf<String,String>()
        body["email"]=binding.etEmail.text.toString()
        body["password"]=binding.edPassword.text.toString()
        return body
    }

    private fun goRegister() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
    }
}