package com.android.jetpackcomposelandofcoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = rememberScrollState()
            val lazyState = rememberLazyListState()
//            Column(
//                modifier = Modifier.verticalScroll(
//                    state = state
//                )
//            ) {
//                (0..100).forEach {
//                    Text(
//                        text = "item #$it",
//                        fontSize = 16.sp,
//                        modifier = Modifier.padding(16.dp)
//                    )
//                }
//            }
//            Row(
//                modifier = Modifier.horizontalScroll(
//                    state = state
//                )
//            ) {
//                (0..100).forEach {
//                    Text(
//                        text = "item #$it",
//                        fontSize = 16.sp,
//                        modifier = Modifier.padding(16.dp)
//                    )
//                }
//            }
//            LazyColumn (
//                modifier = Modifier.fillMaxSize(),
//                state = lazyState,
//                contentPadding = PaddingValues(15.dp),
//                reverseLayout = true,
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ){
//                items(10000){
//                    Text(
//                        text = "item #$it",
//                        fontSize = 16.sp,
//                        modifier = Modifier.padding(16.dp)
//                    )
//                }
//            }
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3)
            ) {
                items(10000) {
                    Text(text = it.toString())
                }
            }
        }
    }
}
