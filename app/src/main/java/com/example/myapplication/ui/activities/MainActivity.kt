package com.example.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.tools.extentions.viewBinding
import com.example.myapplication.ui.adapter.BaseProjectListAdapter
import com.example.myapplication.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val listAdapter by lazy {
        BaseProjectListAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initViewModel()
    }

    private fun initView() {
        binding.recyclerView.adapter = listAdapter
        binding.addItem.setOnClickListener {
            viewModel.addNewCompany()
        }
    }

    private fun initViewModel() {
         viewModel.displayVO.observe(this) {
             Log.e("wtfwtf",it.size.toString())
             listAdapter.submitList(it)
         }
    }
}