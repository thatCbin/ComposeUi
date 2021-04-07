package com.cbin.compseui.layout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cbin.compseui.R
import com.cbin.compseui.ui.theme.CompseUiTheme

/**
 * @author Cbin
 * @CreateDate 2021/4/7
 * @describe 布局
 */
class LayoutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseUiTheme {
                ComposableUi()
            }
        }
    }

    /**
     * ui
     */
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ComposableUi() {
        Column() {
            Image(painter = painterResource(R.drawable.item_pay_chicked), contentDescription = "")

            Row(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Yellow),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    Modifier
                        .size(50.dp)
                        .background(Color.Red)
                )
                Box(
                    Modifier
                        .size(40.dp)
                        .background(Color.Blue)
                        .padding(10.dp)

                )
            }

        }

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LayoutActivity::class.java))
        }
    }
}