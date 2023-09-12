package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.VariantBinding

class VariantAdapter : RecyclerView.Adapter<VariantAdapter.VariantHolder>(){
    val countList = ArrayList<Variant>()
    class VariantHolder(item: View) :RecyclerView.ViewHolder(item) {
        val binding = VariantBinding.bind(item)
        fun bind(variantT: Variant) = with(binding){
            countView.text = variantT.count.toString()
            imageView.setImageResource(variantT.img)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariantHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.variant, parent, false)
        view.setOnClickListener(){

        }
        return VariantHolder(view)

    }

    override fun getItemCount(): Int {
    return countList.size
    }

    override fun onBindViewHolder(holder: VariantHolder, position: Int) {
    holder.bind(countList[position])
    }
    fun addCount(variant: Variant){
        countList.add(variant)
        notifyDataSetChanged()
    }
    fun clearCount(variant: Variant){
        countList.clear()
        notifyDataSetChanged()
    }

}




