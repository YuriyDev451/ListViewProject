package com.example.twoactivity.presentation.newProdust

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddProductViewModel: ViewModel() {


    var id = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var description = MutableLiveData<String>()

    var errorDescription = MutableLiveData<String>()

    var newProductCallBack = MutableLiveData<Boolean>()

    fun addNewProductInserted(){
        if (id.value.isNullOrEmpty()
            || name.value.isNullOrEmpty()
            || description.value.isNullOrEmpty()){
            errorDescription.postValue("Zapolnite polya")
            return
        }
        newProductCallBack.postValue(true)
    }


}