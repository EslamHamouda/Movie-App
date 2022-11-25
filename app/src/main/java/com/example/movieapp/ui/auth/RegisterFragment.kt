package com.example.movieapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.movieapp.ui.viewmodel.AuthViewModel
import com.example.movieapp.data.models.request.RegisterRequest
import com.example.movieapp.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    val viewModel: AuthViewModel by viewModels()

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

        binding.btnRegister.setOnClickListener { viewModel.register(getRegisterData()) }

        lifecycleScope.launch {
            viewModel.registerResponse.observe(viewLifecycleOwner) {
                if (it.isSuccessful){
                    Toast.makeText(requireContext(),"Register success", Toast.LENGTH_SHORT).show()
                    requireActivity().getSharedPreferences("uId",0).edit().putString("name",binding.etFullName.text.toString()).apply()
                    /*startActivity(Intent(requireActivity(), MainActivity::class.java))
                    requireActivity().finish()*/
                    findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
                }
                else{

                    Toast.makeText(requireContext(),"Register failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun getRegisterData(): RegisterRequest {
        return RegisterRequest(
            binding.etFullName.text.toString(),
            binding.etEmail.text.toString(),
            binding.etPassword.text.toString(),
            binding.etPhoneNumber.text.toString())
    }

    private fun goLogin() {
        findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
    }

}