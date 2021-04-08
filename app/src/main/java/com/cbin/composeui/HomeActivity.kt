package com.cbin.composeui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cbin.composeui.layout.RowActivity
import com.cbin.composeui.ui.theme.CompseUiTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseUiTheme {
                NewsStory()
            }
        }
    }


    private fun btnClick() {
        RowActivity.start(this)
    }

    private fun btn2Click() {
        Toast.makeText(applicationContext, "B", Toast.LENGTH_LONG).show()
    }

    /**
     * ui
     */
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun NewsStory() {
        Column(
            //verticalArrangement: Arrangement. Vertical = Arrangement . Top,
            //horizontalAlignment: Alignment.Horizontal = Alignment.Start,
        ) {

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text =
                    "Davenport, California",
                    style = typography.body2
                )
                Text(
                    text = "December 2018",
                    style = typography.body2
                )
                Spacer(Modifier.height(16.dp))
            }

            Column(modifier = Modifier.padding(16.dp)) {

                Button(
                    onClick = { btnClick() }
                ) {
                    Text(
                        text = "AAAAAAAA",
                        style = typography.body2,
                    )
                }

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = {
                        btn2Click()
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.header),
                        contentDescription = "",
                        modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier.padding(16.dp),
                    content = {
                        Text("Some text")
                        Text("Some more text")
                    }
                )
            }
        }

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }
}