
package dev.faith.mypost
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import dev.faith.mypost.databinding.PostListItemBinding

class PostRvAdapter( var posts: List<Post>): RecyclerView.Adapter<PostViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PostViewHolder{
        var binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = posts.get(position)
        with(holder.binding) {
            tvUserId.text = currentPost.userId.toString()
            tvId.text= currentPost.id.toString()
            tvtitle.text = currentPost.title
           tvbody.text=currentPost.body


            val context = holder.itemView.context
            holder.binding.cvposts.setOnClickListener{
                val intent = Intent(context, CommentsActivity::class.java)
                intent.putExtra("POST_ID",currentPost.id)
                context.startActivity(intent)
            }

        }
    }


    override fun getItemCount(): Int {
        return posts.size
    }
}
class PostViewHolder(var binding: PostListItemBinding):RecyclerView.ViewHolder(binding.root)