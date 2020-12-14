package com.example.tugasmodul10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasmodul10.Database.phone
import kotlinx.android.synthetic.main.phone_item.view.*

class phoneAdapter : ListAdapter<phone, phoneAdapter.phoneHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<phone>() {
            override fun areItemsTheSame(oldItem: phone, newItem: phone): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: phone, newItem: phone): Boolean {
                return oldItem.Nama == newItem.Nama && oldItem.Notelp == newItem.Notelp
                        && oldItem.email == newItem.email && oldItem.description == newItem.description
            }
        }
    }
    private var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): phoneHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.phone_item, parent, false)
        return phoneHolder(itemView)
    }
    override fun onBindViewHolder(holder: phoneHolder, position: Int) {
        val currentphone: phone = getItem(position)
        holder.textViewTitle.text = currentphone.Nama
        holder.textViewnotelp.text = currentphone.Notelp
    }
    fun getphoneAt(position: Int): phone {
        return getItem(position)
    }
    inner class phoneHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(getItem(position))
                }
            }
        }
        var textViewTitle: TextView = itemView.text_view_nama
        var textViewnotelp: TextView = itemView.text_view_notelp

    }
    interface OnItemClickListener {
        fun onItemClick(phone: phone)
    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}