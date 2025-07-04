package com.myteam.hackathonapp.presentation.routines.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myteam.hackathonapp.data.dto.response.RoutineItemDto
import kotlinx.coroutines.delay

@Composable
fun LazyRoutineComponent(
    name: String,
    routines: List<RoutineItemDto>,
    onDeleteRoutine: (routineId: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val lazyState = rememberLazyListState()

    Column(modifier = modifier) {
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.padding(start = 29.dp, bottom = 17.dp)
        )

        LazyColumn(
            modifier = Modifier.height(180.dp),
            state = lazyState,
            contentPadding = PaddingValues(bottom = 8.dp)
        ) {
            items(
                items = routines,
                key = { item -> item.routineId }
            ) { item ->
                SwipeToDeleteContainer(
                    onDelete = { onDeleteRoutine(item.routineId) }
                ) {
                    RoutineComponent(item)
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToDeleteContainer(
    onDelete: () -> Unit,
    animationDuration: Int = 500,
    content: @Composable () -> Unit
) {
    var isRemoved by remember{
        mutableStateOf(false)
    }
    val state = rememberDismissState(
        confirmStateChange = { value->
            if(value == DismissValue.DismissedToStart){
                isRemoved = true
                true
            } else false
        }
    )

    LaunchedEffect(isRemoved) {
        if(isRemoved){
            delay(animationDuration.toLong())
            onDelete() // actual delete
        }
    }

    AnimatedVisibility(
        visible = !isRemoved,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDuration),
            shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {
        SwipeToDismiss(
            state = state,
            background = {
                DeleteBackground(swipeDismissState = state)
            },
            dismissContent = { content() },
            directions = setOf(DismissDirection.EndToStart) // remove this for both
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DeleteBackground(
    swipeDismissState: DismissState
){
    val color = if(swipeDismissState.dismissDirection == DismissDirection.EndToStart) {
        Color(0xFFDD4A4A)
    } else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        Text(
            text = "Delete",
            fontSize = 12.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFFF6F6F6)
        )
    }
}

data class RoutineWrapper(
    val id: Int,
    val content: @Composable () -> Unit
)