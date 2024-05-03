package com.mucute.simple.admin.composable

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun Table(content: LazyListScope.() -> Unit) {
    val scroller = rememberScrollState()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(BorderStroke(1.dp, color = Color(0xFFF0F0F0)))
    ) {
        content(this)
    }
}

interface TableScope
class TableScopeImpl() : LazyItemScope {
    @ExperimentalFoundationApi
    override fun Modifier.animateItemPlacement(animationSpec: FiniteAnimationSpec<IntOffset>): Modifier {
        return Modifier
    }

    override fun Modifier.fillParentMaxHeight(fraction: Float): Modifier {
        return Modifier
    }

    override fun Modifier.fillParentMaxSize(fraction: Float): Modifier {
        return Modifier
    }

    override fun Modifier.fillParentMaxWidth(fraction: Float): Modifier {
        return Modifier
    }
}

@Composable
fun LazyListScope.TableItem(
    onClick: (() -> Unit)? = null,
    onLongClick: ((DpOffset) -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Row {
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .height(40.dp)
                .width(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

fun LazyListScope.Header(state: ScrollState, content: @Composable () -> Unit) {
    item {
        Row(
            modifier = Modifier
                .horizontalScroll(state)
                .background(Color(0xFFF0F0F0))
        ) { content() }
    }
}

fun LazyListScope.TableRow(state: ScrollState, content: @Composable () -> Unit) {
    item {
        Row(modifier = Modifier.horizontalScroll(state)) { content() }
    }
}

@Composable
fun TableScope.Body() {

}

@Composable
fun TableScope.Footer() {

}