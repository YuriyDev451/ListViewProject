package com.example.twoactivity.presentation.productList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.twoactivity.databinding.ActivityMainBinding
import com.example.twoactivity.presentation.newProdust.ActivityAddProduct

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel

    }

    fun openActivityAddProduct(){
        val intent = Intent(this, ActivityAddProduct::class.java)
        startActivity(intent)
    }

    fun observeAll(){
        viewModel.onClick.observe(this){
            if (it){

                openActivityAddProduct()
            }

        }
    }

    fun removeObservers(){
        viewModel.onClick.removeObservers(this)
        viewModel.onClick.postValue(false)
    }

    override fun onResume() {
        super.onResume()
        observeAll()
    }

    override fun onPause() {
        super.onPause()
    }



}