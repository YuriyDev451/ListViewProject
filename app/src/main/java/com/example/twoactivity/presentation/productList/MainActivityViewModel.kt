package com.example.twoactivity.presentation.productList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel (){


    var onClick = MutableLiveData<Boolean>()

    fun buttonOnSelected(){
        onClick.postValue(true)
    }


}