package com.cbin.compseui.layout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import com.cbin.compseui.ui.theme.CompseUiTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

/**
 * @author Cbin
 * @CreateDate 2021/4/7
 * @describe 使用组合布局
 */
class RowActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseUiTheme {
                MoveBoxWhereTapped()
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun NewUi() {
        Row(Modifier.padding(10.dp)) {
            Text(
                text = "Hello world",
                // This Text is inside a RowScope so it has access to
                // Alignment.CenterVertically but not to
                // Alignment.CenterHorizontally, which would be available
                // in a ColumnScope.
                modifier = (Modifier.align(Alignment.CenterVertically)),
            )

        }
        Box(
            modifier = Modifier.drawBehind {
                // This method accepts a lambda of type DrawScope.() -> Unit
                // therefore in this lambda we can access properties and functions
                // available from DrawScope, such as the `drawRectangle` function.
                drawRect(color = Color.Red)
            }
        )
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun MoveBoxWhereTapped() {
        // Creates an `Animatable` to animate Offset and `remember` it.
        val animatedOffset = remember {
            Animatable(Offset(0f, 0f), Offset.VectorConverter)
        }

        Box(
            // The pointerInput modifier takes a suspend block of code
            Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    // Create a new CoroutineScope to be able to create new
                    // coroutines inside a suspend function
                    coroutineScope {
                        while (true) {
                            // Wait for the user to tap on the screen
                            val offset = awaitPointerEventScope {
                                awaitFirstDown().position
                            }
                            // Launch a new coroutine to asynchronously animate to where
                            // the user tapped on the screen
                            launch {
                                // Animate to the pressed position
                                animatedOffset.animateTo(offset)
                            }
                        }
                    }
                }
        ) {
            Text("Tap anywhere", Modifier.align(Alignment.Center))
            Box(
                Modifier
                    .offset {
                        // Use the animated offset as the offset of this Box
                        IntOffset(
                            animatedOffset.value.x.roundToInt(),
                            animatedOffset.value.y.roundToInt()
                        )
                    }
                    .size(40.dp)
                    .background(Color(0xff3c1361), CircleShape)
            )
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, RowActivity::class.java))
        }
    }
}