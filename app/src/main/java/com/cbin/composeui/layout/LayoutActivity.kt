package com.cbin.composeui.layout

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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cbin.composeui.R
import com.cbin.composeui.ui.theme.CompseUiTheme

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
                Ui3()
            }
        }
    }

    fun a() {
        val a = 5
        var b = 4
        print(a + b)
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
    /**
     * 如需在 Row 中设置子项的位置，请设置 horizontalArrangement 和 verticalAlignment 参数。
     * 对于 Column，请设置 verticalArrangement 和 horizontalAlignment 参数
     */
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Ui1() {
        Column() {
            //ArtistCard1(onClick = { C1() })
            //ArtistCard2(onClick = { C2() })
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

    /**
     * 在上面的代码中，整个区域（包括周围的内边距）都是可点击的，因为 padding 修饰符应用在 clickable 修饰符后面。
     * 如果修饰符顺序相反，由 padding 添加的空间就不会响应用户输入
     */
    @Composable
    fun ArtistCard1(onClick: () -> Unit) {
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            ImageView()
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
            ImageView()
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
            ImageView()
        }
    }

    @Composable
    fun ImageView() {
        Row(verticalAlignment = Alignment.CenterVertically) { /*...*/ }
        Spacer(Modifier.size(20.dp))
        Card(elevation = 4.dp) {
            Image(
                painter = painterResource(id = R.drawable.ic_mod),
                contentDescription = ""
            )
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun Ui2() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PaddedComposable()
            Spacer(Modifier.height(10.dp))
            SizedComposable()
            Spacer(Modifier.height(10.dp))
            FixedSizeComposable()
        }
    }

    /**
     * padding 修饰符
     */
    @Composable
    fun PaddedComposable() {
        Text(
            "Hello World", modifier = Modifier
                .background(Color.Green)
                .padding(20.dp)
        )
    }

    //使用 size 修饰符设置尺寸
    @Composable
    fun SizedComposable() {
        Box(
            Modifier
                .size(100.dp, 100.dp)
                .background(Color.Red)
        )
    }

    /**
     * 使用 requiredSize 修饰符
     */
    @Composable
    fun FixedSizeComposable() {
        Box(
            Modifier
                .size(90.dp, 150.dp)
                .background(Color.Green)
        ) {
            Box(
                Modifier
                    .requiredSize(100.dp, 100.dp)
                    .background(Color.Red)
            )
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Ui3() {
        Column() {

            MatchParentSizeComposable()
            MatchParentSizeComposable2()
            TextWithPaddingFromBaseline()
            OffsetComposable()
            FlexibleComposable()
        }

    }

    /**
     *  如果您希望将子布局的尺寸设置为与父 Box 相同，但不影响 Box 的尺寸，请使用 matchParentSize 修饰符。
     *  请注意，matchParentSize 仅在 Box 作用域内可用，这意味着它仅适用于 Box 可组合项的直接子项。
     *  在下面的示例中，内部 Spacer 从其父 Box 获取自己的尺寸，而后者又从其包含的 Text 获取自己的尺寸。
     */
    @Composable
    fun MatchParentSizeComposable() {
        Column(modifier = Modifier.size(60.dp)) {
            Box {
                Spacer(
                    Modifier
                        .matchParentSize()
                        .background(Color.Green)
                )
                Text("Hello World")
            }

        }
    }

    /**
     * 如果使用 fillMaxSize 代替 matchParentSize，Spacer 将占用父项允许的所有可用空间，反过来使父项展开并填满所有可用空间
     */
    @Composable
    fun MatchParentSizeComposable2() {
        Column(modifier = Modifier.size(60.dp)) {
            Box {
                Spacer(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Green)
                )
                Text("Hello World")
            }

        }
    }

    /**
     * 如需在文本基线上方添加内边距，以实现从布局顶部到基线保持特定距离，请使用 paddingFromBaseline 修饰符
     */
    @Composable
    fun TextWithPaddingFromBaseline() {
        Box(
            Modifier
                .background(Color.Yellow)
        ) {
            Text(text = "Hi there!", Modifier.paddingFromBaseline(top = 50.dp))
        }
    }

    /**
     * 要相对于原始位置放置布局，请添加 offset 修饰符，并在 x 轴和 y 轴中设置偏移量。
     * 偏移量可以是正数，也可以是非正数。padding 和 offset 之间的区别在于
     * ，向可组合项添加 offset 不会改变其测量结果
     */
    @Composable
    fun OffsetComposable() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                Modifier
                    .background(Color.Yellow)
                    .size(width = 200.dp, height = 200.dp),
            ) {
                Text(
                    "padding在 offset前面 不会影响 offset 反之则会",
                    Modifier
                        .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)

                        .offset(x = 10.dp, y = 10.dp)

                )
            }
        }

    }


    /**
     * Row 和 Column 中的 weight 修饰符
     */
    @Composable
    fun FlexibleComposable() {
        Row(Modifier.width(210.dp)) {
            Box(
                Modifier
                    .weight(3f)
                    .height(50.dp)
                    .background(Color.Blue)
            )
            Box(
                Modifier
                    .weight(2f)
                    .height(50.dp)
                    .background(Color.Red)
            )
        }
    }


    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LayoutActivity::class.java))
        }
    }
}