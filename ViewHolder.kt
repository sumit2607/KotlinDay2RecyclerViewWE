package com.example.kotlinday2recyclerviewwe

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

fun setData(responseDTO: ResponseDTO){
   itemView.apply {
       tvName.text = responseDTO.name
       tvEmail.text = responseDTO.email
       tvBody.text = responseDTO.body
   }

}}