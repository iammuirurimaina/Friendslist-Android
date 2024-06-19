package com.example.friendslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friendslist.R
import com.example.friendslist.Friend

class FriendAdapter(private var friendList: List<Friend>) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val friend = friendList[position]
        holder.bind(friend)
    }

    override fun getItemCount(): Int = friendList.size

    fun updateList(newList: List<Friend>) {
        friendList = newList
        notifyDataSetChanged()
    }

    inner class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val contactTextView: TextView = itemView.findViewById(R.id.contactTextView)
        private val birthdayTextView: TextView = itemView.findViewById(R.id.birthdayTextView)

        fun bind(friend: Friend) {
            nameTextView.text = friend.name
            contactTextView.text = friend.contact
            birthdayTextView.text = friend.birthday
        }
    }
}