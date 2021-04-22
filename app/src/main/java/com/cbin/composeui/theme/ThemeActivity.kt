package com.cbin.composeui.theme

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cbin.composeui.layout.ConstraintLayoutActivity
import com.cbin.composeui.ui.theme.*

/**
 * @author Cbin
 * @CreateDate 2021/4/15
 * @describe
 */
class ThemeActivity : ComponentActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ThemeActivity::class.java))
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


    private val DarkColors = darkColors(
        primary = Purple200,
        secondary = Teal200,
    )
    private val LightColors = lightColors(
        primary = Purple500,
        secondary = Teal500,
    )

    @Preview
    @Composable
    fun Ui() {

    }

}
