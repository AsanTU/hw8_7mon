package com.example.hw8_7mon.ui.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw8_7mon.ui.fragments.main.NoteViewModel
import com.example.hw8_7mon.data.model.NoteEntity
import com.example.hw8_7mon.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveBtn.setOnClickListener {
            val title = binding.titleEt.text.toString()
            val content = binding.contentEt.text.toString()
            val category = ""
            val priority = 0
            viewModel.addNote(NoteEntity(0, title,content,category,priority))
            findNavController().popBackStack()
        }
    }
}