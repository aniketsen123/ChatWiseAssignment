package com.seventhelement.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seventhelement.model.Product
import com.squareup.picasso.Picasso

class Adapter( private val list: List<Product>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.productname)
        val descp=itemView.findViewById<TextView>(R.id.descrip)
        val cat=itemView.findViewById<TextView>(R.id.category)

        var img: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = list[position]
      holder.name.text=current.title
        holder.cat.text=current.category
        holder.descp.text=current.description
        Picasso.get().load(current.thumbnail).into(holder.img);

    }

    override fun getItemCount(): Int {
        return list.size
    }


}