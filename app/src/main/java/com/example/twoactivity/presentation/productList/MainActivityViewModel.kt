package com.example.twoactivity.presentation.productList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twoactivity.domain.Product

class MainActivityViewModel: ViewModel () {


    private var productList = mutableListOf<Product>()
    var onClick = MutableLiveData<Boolean>()

    fun buttonOnSelected() {
        onClick.postValue(true)
    }

    fun addNewProduct(aProduct : Product) : Product? {
        if(aProduct.name.isEmpty()) {
            return null
        }

        productList.add(aProduct)
        return aProduct
    }



}