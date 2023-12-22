package com.example.twoactivity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.example.twoactivity.R
import com.example.twoactivity.databinding.ListItemProductBinding
import com.example.twoactivity.domain.Product

class ProductListAdapter(val context: Context, private var dataList: MutableList<Product>, var onClickItem: (Product)->Unit): BaseAdapter() {

    fun addNewItem(aProduct: Product){
        dataList.add(aProduct)
        notifyDataSetChanged()

    }



    override fun getCount(): Int {
       return dataList.count()
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View { // 0 item layout

        var newContentView = convertView
        var holder: ViewHolder

        if(convertView==null){

            val binding: ListItemProductBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item_product,
                parent,
                false
            )

            newContentView = binding.root
            holder = ViewHolder(binding, onClickItem)
            holder.bind(dataList[position])

            newContentView?.tag = holder


            return binding.root
        }else{
            holder = convertView.tag as ViewHolder
            holder.bind(dataList[position])
        }
        return newContentView!!

    }

    private class ViewHolder(var binding: ListItemProductBinding, var onClickItem: (Product)->Unit){

        fun bind(product: Product){
            binding.textProductName.text = product.name
            binding.textProductDetail.text = product.description
            binding.product = product

            binding.root.setOnClickListener{
                onClickItem(binding.product as Product)

            }
        }
    }

}