package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.myapplication.R
import com.example.myapplication.model.User

class UserAdapter(
    private val userList: List<User>,
    private val onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvUserName)
        val tvEmail: TextView = view.findViewById(R.id.tvUserEmail)
        val ivAvatar: ImageView = view.findViewById(R.id.ivUserAvatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.tvName.text = "${user.first_name} ${user.last_name}"
        holder.tvEmail.text = user.email

        // Glide untuk memastikan gambar bulat
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .transform(CircleCrop())
            .placeholder(R.drawable.ic_user)
            .into(holder.ivAvatar)

        holder.itemView.setOnClickListener { onItemClick(user) }
    }

    override fun getItemCount() = userList.size
}
