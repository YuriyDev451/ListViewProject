package com.example.twoactivity.presentation.newProdust

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddProductViewModel: ViewModel() {


    var id = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var description = MutableLiveData<String>()



}