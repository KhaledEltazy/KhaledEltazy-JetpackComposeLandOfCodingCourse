import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun NumbersList(){
    val numbers = remember {
        (0..100).toList()
    }
    val scrollState = rememberLazyListState()
    val isFabVisible by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex >= 5
        }
    }

    val scope = rememberCoroutineScope()
    Scaffold(
        floatingActionButton = {
            //hide FAB
            if (isFabVisible) {
                FloatingActionButton(onClick = {
                    //Scroll Up
                    scope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
                }
            }
        }
    ){
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding()),
            state = scrollState
        ){
            items(numbers){ number ->
                Text(
                    text = number.toString() ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}