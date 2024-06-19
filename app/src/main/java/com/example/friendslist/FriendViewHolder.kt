import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friendslist.R
import com.example.friendslist.Friend



class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private val contactTextView: TextView = itemView.findViewById(R.id.contactTextView)
    private val birthdayTextView: TextView = itemView.findViewById(R.id.birthdayTextView)

    fun bind(friend: Friend) {
        nameTextView.text = friend.name
        contactTextView.text = friend.contact
        birthdayTextView.text = friend.birthday
    }
}