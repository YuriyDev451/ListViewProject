package com.example.twoactivity.domain

import android.os.Parcelable
import androidx.appcompat.widget.ActivityChooserView.InnerLayout
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product (
    var id: Int,
    val name: String,
    var description: String): Parcelable {

    }