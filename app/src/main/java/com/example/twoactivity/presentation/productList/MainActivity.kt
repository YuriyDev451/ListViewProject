package com.example.twoactivity.presentation.productList

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.twoactivity.adapters.ProductListAdapter
import com.example.twoactivity.databinding.ActivityMainBinding
import com.example.twoactivity.domain.Product
import com.example.twoactivity.presentation.newProdust.ActivityAddProduct

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    var adapter: ProductListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel

        setContentView(binding.root)


        var items = mutableListOf<Product>()
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))
        items.add(Product(0, "fruit", "description"))


        val adapter = ProductListAdapter(this.baseContext, items, onClickItem = {product ->  
            println(product.name)
        } )
        binding.productListView.adapter = adapter

    }

    fun openActivityAddProduct(){
        val intent = Intent(this, ActivityAddProduct::class.java)
        // startActivity(intent)
        newProduct.launch(intent)
    }




    private val newProduct = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){

        if (it.resultCode == Activity.RESULT_OK) {
            val item = it.data?.getParcelableExtra<Product>("product")
            item?.let {
                adapter
            }
        }
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
        removeObservers()
    }



}