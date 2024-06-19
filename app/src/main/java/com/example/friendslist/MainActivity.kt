package com.example.friendslist

import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.friendslist.ui.theme.FriendslistTheme
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friendslist.FriendAdapter



class MainActivity : AppCompatActivity() {
    private lateinit var friendAdapter: FriendAdapter
    private val friendList = mutableListOf<Friend>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the friend list with some sample data
        friendList.addAll(
            listOf(
                Friend("John Doe", "123-456-7890", "01/01/1990"),
                Friend("Jane Smith", "987-654-3210", "15/05/1995"),
                Friend("Bob Johnson", "555-123-4567", "20/12/1988")
            )
        )

        // Set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.friendsRecyclerView)
        friendAdapter = FriendAdapter(friendList)
        recyclerView.adapter = friendAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set up the search functionality
        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val searchQuery = s.toString().trim()
                filterFriends(searchQuery)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterFriends(searchQuery: String) {
        val filteredList = if (searchQuery.isBlank()) {
            friendList
        } else {
            friendList.filter {
                it.name.contains(searchQuery, ignoreCase = true)
            }
        }
        friendAdapter.updateList(filteredList)
    }
}