package com.qibar.notes.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.qibar.notes.R
import com.qibar.notes.databinding.ActivityAddBinding
import com.qibar.notes.ui.detail.DetailActivity

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding

    private var title: String? = ""
    private var content: String? = ""
    private var createdAt: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        title = intent.getStringExtra(DetailActivity.TITLE)
        content = intent.getStringExtra(DetailActivity.CONTENT)
        createdAt = intent.getStringExtra(DetailActivity.CREATED_AT)

        binding.etTitle.setText(title ?: "")
        binding.etContent.setText(content ?: "")
        binding.tvDate.text = createdAt ?: ""
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_save -> {
                onBackPressed()
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