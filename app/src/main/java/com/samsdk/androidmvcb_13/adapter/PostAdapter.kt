package com.samsdk.androidmvcb_13.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samsdk.androidmvcb_13.activity.MainActivity
import com.samsdk.androidmvcb_13.databinding.ItemPostListBinding
import com.samsdk.androidmvcb_13.model.Post

class PostAdapter(
    private val activity: MainActivity,
    private val items: ArrayList<Post>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemPostListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = items[position]

        holder.binding.apply {
            textTitle.text = post.title
            textBody.text = post.body
            linearLayout.setOnLongClickListener {
                activity.deletePostDialog(post)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class PostViewHolder(val binding: ItemPostListBinding): RecyclerView.ViewHolder(binding.root)
}