package com.cbin.composeui.layout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.cbin.composeui.ui.theme.CompseUiTheme

/**
 * @author Cbin
 * @CreateDate 2021/4/12
 * @describe Constraintlayout
 */
class ConstraintLayoutActivity : ComponentActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ConstraintLayoutActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseUiTheme {
                Ui()
            }
        }
    }


    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Ui() {
        Column() {
            ConstraintLayoutContent()
            Spacer(
                Modifier
                    .height(10.dp)
                    .background(Color.Yellow)
            )
            DecoupledConstraintLayout()
            Spacer(
                Modifier
                    .height(10.dp)
                    .background(Color.Yellow)
            )

            MyBasicColumn(Modifier.fillMaxWidth()) {
                Text("MyBasicColumn")
                Text("places items")
                Text("vertically.")
                Text("We've done it by hand!")
            }
            Spacer(
                Modifier
                    .height(10.dp)
                    .background(Color.Yellow)
            )
            TwoTexts(Modifier, "text1", "text2")
        }

    }


    @Composable
    fun ConstraintLayoutContent() {
        ConstraintLayout {
            // Create references for the composables to constrain
            val (button, text) = createRefs()

            Button(
                onClick = { /* Do something */ },
                //将引用“button”分配给可组合的按钮
                //并将其约束到ConstraintLayout的顶部
                modifier = Modifier.constrainAs(button) {
                    top.linkTo(parent.top, margin = 16.dp)
                }
            ) {
                Text("Button")
            }

            // Assign reference "text" to the text composable
            //并将其约束到可组合按钮的底部
            Text("Text", Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            })
        }
    }

    @Composable
    fun DecoupledConstraintLayout() {
        BoxWithConstraints {
            val constraints = if (minWidth < 600.dp) {
                decoupledConstraints(margin = 16.dp) // Portrait constraints
            } else {
                decoupledConstraints(margin = 32.dp) // Landscape constraints
            }

            ConstraintLayout(constraints) {
                Button(
                    onClick = { /* Do something */ },
                    modifier = Modifier.layoutId("button")
                ) {
                    Text("Button")
                }

                Text("Text", Modifier.layoutId("text"))
            }
        }
    }

    private fun decoupledConstraints(margin: Dp): ConstraintSet {
        return ConstraintSet {
            val button = createRefFor("button")
            val text = createRefFor("text")

            constrain(button) {
                top.linkTo(parent.top, margin = margin)
            }
            constrain(text) {
                top.linkTo(button.bottom, margin = margin)
            }
        }
    }


    @Composable
    fun MyBasicColumn(
        modifier: Modifier = Modifier,
        content: @Composable() () -> Unit
    ) {
        Layout(
            modifier = modifier,
            content = content
        ) { measurables, constraints ->
            // 不要进一步限制子视图，在给定约束的情况下对其进行度量
            // List of measured children(被测量每个 children  名单)
            val placeables = measurables.map { measurable ->
                // Measure each children(测量每个 children )
                measurable.measure(constraints.copy(minHeight = 0))
            }
            // 尽可能设置版面的大小
            layout(constraints.maxWidth, constraints.maxHeight) {
                // Track the y co-ord we have placed children up to(跟踪我们将 children 安置到的y坐标)
                var yPosition = 0

                // 将子级放置在父级布局中
                placeables.forEach { placeable ->
                    // Position item on the screen(屏幕上的位置项目)
                    placeable.place(x = 0, y = yPosition)

                    // 记录放置的y坐标
                    yPosition += placeable.height
                }
            }
        }
    }


    @Composable
    fun TwoTexts(modifier: Modifier = Modifier, text1: String, text2: String) {
        Row(modifier) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
                    .wrapContentWidth(Alignment.Start),
                text = text1
            )

            Divider(
                color = Color.Black, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
                    .wrapContentWidth(Alignment.End),

                text = text2
            )

        }
    }
}