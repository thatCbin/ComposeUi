package com.cbin.composeui.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

/**
 * @author Cbin
 * @CreateDate 2021/4/12
 * @describe 无意义间隔器
 */

@Composable
fun SpacerHeight(dp: Dp) {
    Spacer(Modifier.height(dp))
}

@Composable
fun SpacerWidth(dp: Dp) {
    Spacer(Modifier.width(dp))
}

@Composable
fun SpacerWidthHeight(w: Dp, h: Dp) {
    Spacer(
        Modifier
            .width(w)
            .height(h)
    )
}