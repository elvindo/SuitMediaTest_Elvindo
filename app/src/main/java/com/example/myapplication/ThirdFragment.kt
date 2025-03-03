package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.model.User
import com.example.myapplication.network.RetrofitInstance
import kotlinx.coroutines.launch

class ThirdFragment : Fragment() {
    private lateinit var rvUsers: RecyclerView
    private val userList = mutableListOf<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        rvUsers = view.findViewById(R.id.rvUsers)
        val btnBack: ImageView = view.findViewById(R.id.btnBack) // 🔹 Tambahkan tombol back

        rvUsers.layoutManager = LinearLayoutManager(requireContext())

        // 🔹 Tambahkan aksi ketika tombol Back ditekan
        btnBack.setOnClickListener {
            findNavController().navigateUp() // Kembali ke Second Screen
        }

        // Fetch data dari API
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getUsers(1, 10)
                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        userList.addAll(it)
                        rvUsers.adapter = UserAdapter(userList) { selectedUser ->
                            sendUserToSecondScreen(selectedUser)
                        }
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun sendUserToSecondScreen(user: User) {
        val navController = findNavController()
        Log.d("ThirdFragment", "User Selected: ${user.first_name} ${user.last_name}") // Debug Log

        navController.previousBackStackEntry?.savedStateHandle?.set(
            "selectedUser", "${user.first_name} ${user.last_name}"
        )

        navController.popBackStack()
    }
}
