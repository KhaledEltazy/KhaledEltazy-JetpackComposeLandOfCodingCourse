package com.android.jetpackcomposelandofcoding.produced_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

@Composable
fun PostCard(postId : Int){
    val post by produceState<Result<Post>?>(initialValue = null) {
        value = getPostInformation(postId)
    }

    if(post == null){
        //loading
    } else {
        post?.onSuccess {

        }
        post?.onFailure {  }
    }
}

suspend fun getPostInformation(id : Int): Result<Post>{
    return withContext(Dispatchers.IO){
        delay(3.seconds)
        Result.success(
            Post(
                id = id,
                name = "",
                imageUrl =""
            )
        )
    }
}