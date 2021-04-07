package com.cbin.compseui.layout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
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

    fun C1(): Unit {
        Toast.makeText(this, "1", Toast.LENGTH_LONG).show()
    }

    fun C2(): Unit {
        Toast.makeText(this, "2", Toast.LENGTH_LONG).show()
    }

    fun C3(): Unit {
        Toast.makeText(this, "3", Toast.LENGTH_LONG).show()
    }

    /**
     * ui
     */
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ComposableUi() {
        Column() {
            ArtistCard1(onClick = { C1() })
            ArtistCard2(onClick = { C2() })
            ArtistCard3(onClick = { C3() })

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


    @Composable
    fun ArtistCard1(
        onClick: () -> Unit
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) { /*...*/ }
            Spacer(Modifier.size(20.dp))
            Card(elevation = 4.dp) {
                Image(
                    painter = painterResource(id = R.drawable.ic_mod),
                    contentDescription = ""
                )
            }
        }
    }

    @Composable
    fun ArtistCard2(onClick: () -> Unit) {
        val padding = 16.dp
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(padding)
                .fillMaxWidth()
        ) {
            // rest of the implementation
        }
    }

    @Composable
    fun ArtistCard3(onClick: () -> Unit) {
        val padding = 16.dp
        Column(
            Modifier
                .padding(padding)
                .clickable(onClick = onClick)
                .fillMaxWidth()
        ) {
            // rest of the implementation
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LayoutActivity::class.java))
        }
    }
}