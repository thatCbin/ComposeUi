package com.cbin.composeui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cbin.composeui.layout.ConstraintLayoutActivity
import com.cbin.composeui.layout.LayoutActivity
import com.cbin.composeui.layout.RowActivity
import com.cbin.composeui.ui.theme.CompseUiTheme

/**
 * @author Cbin
 * @CreateDate 2021/4/6
 * @describe
 */

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseUiTheme {
                NewsStory()
            }
        }
    }


    private fun btnClick(id: Int) {
        when (id) {
            0 -> {
                HomeActivity.start(this)
            }
            1 -> {
                RowActivity.start(this)
            }
            2 -> {
                LayoutActivity.start(this)
            }
            3 -> {
                ConstraintLayoutActivity.start(this)
            }
            else -> Toast.makeText(this, "没找到对应按钮功能", Toast.LENGTH_LONG).show()
        }

    }


    /**
     * ui
     */
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun NewsStory() {
        Column(
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                HelloWord()

                Spacer(Modifier.height(10.dp))

                Row() {
                    LayoutA()
                    Spacer(Modifier.width(10.dp))
                    LayoutB()
                    Spacer(Modifier.width(10.dp))
                    LayoutC()
                }

                Spacer(Modifier.height(10.dp))

                ThemeUi()

            }
        }

    }

    @Composable
    fun HelloWord() {
        Button(
            onClick = { btnClick(0) },
            modifier = Modifier
                .height(40.dp)
        ) {
            Text(
                text = "Kotlin 对 Jetpack Compose 的支持",
//                        style = typography.body2,
            )
        }
    }

    @Composable
    fun LayoutA() {
        Button(
            onClick = { btnClick(1) },
            modifier = Modifier
                .height(40.dp)
        ) {
            Text(
                text = "布局1",
//                        style = typography.body2,
            )
        }
    }

    @Composable
    fun LayoutB() {
        Button(
            onClick = { btnClick(2) },
            modifier = Modifier
                .height(40.dp)
        ) {
            Text(
                text = "布局2",
//                        style = typography.body2,
            )
        }
    }

    @Composable
    fun LayoutC() {
        Button(
            onClick = { btnClick(3) },
            modifier = Modifier
                .height(40.dp)
        ) {
            Text(
                text = "Constraintlayout",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    letterSpacing = 0.25.sp
                ),
            )
        }
    }

    @Composable
    fun ThemeUi() {
        Button(
            onClick = { btnClick(3) },
            modifier = Modifier
                .width(100.dp)
                .height(40.dp)
        ) {
            Text(
                text = "主题",
//                        style = typography.body2,
            )
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}