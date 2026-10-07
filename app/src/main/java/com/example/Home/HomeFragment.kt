package com.example.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.Home.Pertemuan5.LimaActivity
import com.example.Home.pertemuan_6.MainActivity6
import com.example.raihan_3tic.LoginActivity
import com.example.raihan_3tic.R
import com.example.raihan_3tic.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val nama = requireActivity().intent.getStringExtra("nama")
        val umur = requireActivity().intent.getIntExtra("umur", 0)

        Log.w("hasil", "Nama: $nama Umur: $umur")

        binding.timpanama.setText(nama)
        binding.btnkembali.setOnClickListener {
//            val intent = Intent(this@MainActivity, LoginActivity::class.java)
//            startActivity(intent)
            requireActivity().finish()

        }
        binding.btnToLima.setOnClickListener {
            val intent = Intent(requireContext(), LimaActivity::class.java)
            startActivity(intent)
        }
        binding.btnEnam.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity6::class.java)
            startActivity(intent)
        }
        binding.btnLogOut.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
        binding.btnsnack.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tampilkan"){
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}