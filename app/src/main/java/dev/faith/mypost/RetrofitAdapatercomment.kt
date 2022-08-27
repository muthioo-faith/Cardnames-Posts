package dev.faith.mypost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.faith.mypost.databinding.ActivityCommentsBinding

class RetrofitAdapatercomment (var comment:List<Comment>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup ,viewType: Int): CommentsViewHolder {
        var binding=ActivityCommentsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComments=comment.get(position)
        with(holder.binding){
            tvPostTitle.text=currentComments.title
            tvPostBody.text=currentComments.body
        }
    }

    override fun getItemCount(): Int {
        return comment.size
    }
}


class CommentsViewHolder(var binding: ActivityCommentsBinding):RecyclerView.ViewHolder(binding.root)

