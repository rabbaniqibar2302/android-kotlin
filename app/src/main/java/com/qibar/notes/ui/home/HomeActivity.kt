package com.qibar.notes.ui.home

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.qibar.notes.R
import com.qibar.notes.R.id.btn_add
import com.qibar.notes.databinding.ActivityHomeBinding
import com.qibar.notes.ui.add.AddActivity
import com.qibar.notes.ui.detail.DetailActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var noteAdapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        noteAdapter = NoteAdapter {
            val detailIntent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.TITLE, it.title)
                putExtra(DetailActivity.CONTENT, it.content)
                putExtra(DetailActivity.CREATED_AT, it.createdAt)
            }
            startActivity(detailIntent)
        }
        binding.rvNote.adapter = noteAdapter

        binding.btnAdd.setOnClickListener {
            val addNoteIntent = Intent(this, AddActivity::class.java)
            startActivity(addNoteIntent)
        }

        observeData()

        viewModel.getNote()

    }

    private fun observeData() {
        viewModel.notes.observe(this) { notes ->
            noteAdapter.submitList(notes)
            binding.viewEmpty.isVisible = notes.isEmpty()
        }
    }
}