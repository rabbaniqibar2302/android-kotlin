package com.qibar.notes.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.qibar.notes.R
import com.qibar.notes.databinding.ActivityDetailBinding
import com.qibar.notes.ui.add.AddActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private var title: String? = ""
    private var content: String? = ""
    private var createdAt: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        title = intent.getStringExtra(TITLE)
        content = intent.getStringExtra(CONTENT)
        createdAt = intent.getStringExtra(CREATED_AT)

        binding.tvTitle.text = title
        binding.tvContent.text = content
        binding.tvDate.text = createdAt
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_edit -> {
                val addIntent = Intent(this, AddActivity::class.java).apply {
                    putExtra(AddActivity.TITLE, title)
                    putExtra(AddActivity.CONTENT, content)
                    putExtra(AddActivity.CREATED_AT, createdAt)
                }
                startActivity(addIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    companion object {
        const val TITLE = "title"
        const val CONTENT = "content"
        const val CREATED_AT = "createdAt"
    }
}