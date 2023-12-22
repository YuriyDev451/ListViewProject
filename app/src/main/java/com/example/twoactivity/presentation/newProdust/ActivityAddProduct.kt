package com.example.twoactivity.presentation.newProdust

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.twoactivity.R
import com.example.twoactivity.databinding.ActivityAddProductBinding
import com.example.twoactivity.databinding.ActivityMainBinding
import com.example.twoactivity.domain.Product
import com.example.twoactivity.presentation.productList.MainActivityViewModel

class ActivityAddProduct : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding
    private lateinit var viewModel: AddProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityAddProductBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this).get(AddProductViewModel::class.java)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModelAdd = viewModel
    }

    override fun onResume() {
        super.onResume()

        observerAll()
    }

    fun observerAll(){
        viewModel.newProductCallBack.observe(this){
            val intent = Intent()
            var product = Product(viewModel.id.value.orEmpty().toInt(), viewModel.name.value.orEmpty(), viewModel.description.value.orEmpty())
            intent.putExtra("product", product)

            setResult(RESULT_OK, intent)
            finish()
        }
        viewModel.errorDescription.observe(this){
            if (!it.isNullOrEmpty()){
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }



}