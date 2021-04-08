package com.cbin.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cbin.composeui.ui.theme.CompseUiTheme

/**
 * @author Cbin
 * @CreateDate 2021/4/7
 * @describe
 */
class ThemeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseUiTheme {
                ComposableUi()
            }
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun ComposableUi() {

    }
}