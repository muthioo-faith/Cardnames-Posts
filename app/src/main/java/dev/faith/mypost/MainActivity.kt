package dev.faith.mypost

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faith.mypost.ApiClient
import dev.faith.mypost.ApiInterface
import dev.faith.mypost.Post
import dev.faith.mypost.PostRvAdapter
import dev.faith.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPost()
    }

    fun fetchPost() {
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPosts()



        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    Toast.makeText(baseContext, "fetched ${post!!.size} posts", Toast.LENGTH_LONG)
                        .show()
                    var postAdapter = PostRvAdapter(post)
                    binding.rvposts.layoutManager = LinearLayoutManager(baseContext)
                    binding.rvposts.adapter = postAdapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }
}