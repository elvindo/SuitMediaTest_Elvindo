package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout fragment_second.xml
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi komponen UI
        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val tvSelectedUser = view.findViewById<TextView>(R.id.tvSelectedUser)
        val btnChooseUser = view.findViewById<Button>(R.id.btnChooseUser)
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)

        val navController = findNavController()

        //Ambil nama dari First Screen
        val previousSavedStateHandle = navController.previousBackStackEntry?.savedStateHandle
        val name = previousSavedStateHandle?.get<String>("userName") ?: "User Name"
        tvUserName.text = name

        //Ambil data dari Third Screen
        val currentSavedStateHandle = navController.currentBackStackEntry?.savedStateHandle
        currentSavedStateHandle?.getLiveData<String>("selectedUser")?.observe(viewLifecycleOwner) { selectedName ->
            tvSelectedUser.text = selectedName // Perbarui label tanpa membuat layar baru
        }

        //Navigasi ke Third Screen
        btnChooseUser.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        //Navigasi ke First Screen (Back Button)
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
