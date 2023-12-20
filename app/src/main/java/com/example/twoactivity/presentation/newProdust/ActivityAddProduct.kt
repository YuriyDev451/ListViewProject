package com.example.twoactivity.presentation.newProdust

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.twoactivity.R
import com.example.twoactivity.databinding.ActivityAddProductBinding
import com.example.twoactivity.databinding.ActivityMainBinding
import com.example.twoactivity.presentation.productList.MainActivityViewModel

class ActivityAddProduct : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding
    private lateinit var viewModel: AddProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddProductBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this).get(AddProductViewModel::class.java)
        setContentView(R.layout.activity_add_product)
    }
}