package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {
    private lateinit var etName: EditText
    private lateinit var etPalindrome: EditText
    private lateinit var btnCheck: Button
    private lateinit var btnNext: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        etName = view.findViewById(R.id.etName)
        etPalindrome = view.findViewById(R.id.etPalindrome)
        btnCheck = view.findViewById(R.id.btnCheck)
        btnNext = view.findViewById(R.id.btnNext)

        btnCheck.setOnClickListener {
            val text = etPalindrome.text.toString().replace("\\s".toRegex(), "").lowercase()
            val isPalindrome = text == text.reversed()

            val message = if (isPalindrome) "isPalindrome" else "Not palindrome"

            // Menampilkan dialog
            AlertDialog.Builder(requireContext())
                .setTitle("Palindrome Check")
                .setMessage(message)
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }


        btnNext.setOnClickListener {
            val name = etName.text.toString().trim()

            if (name.isNotEmpty()) {
                val navController = findNavController()

                Log.d("FirstFragment", "Name Entered: $name") // Debug Log

                navController.currentBackStackEntry?.savedStateHandle?.set("userName", name)

                navController.navigate(R.id.action_firstFragment_to_secondFragment)
            } else {
                Toast.makeText(requireContext(), "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }



        return view
    }
}
