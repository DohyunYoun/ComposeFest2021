package com.my.composeweek2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.my.composeweek2.ui.theme.ComposeWeek2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWeek2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LayoutsCodelab()
                }
            }
        }
    }
}

@Composable
fun LayoutsCodelab() {
}

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        /**
         * width : measured composable width
         * height : measured composable height에 top-to-baseline - first-baseline
         */
        layout(placeable.width, height) {
            placeable.placeRelative(0, placeableY)
        }
    }
)


@Preview
@Composable
fun TextWithPaddingToBaselinePreview() {
    ComposeWeek2Theme {
        Text("Hi there!", Modifier.firstBaselineToTop(24.dp))
    }
}

@Preview
@Composable
fun TextWithNormalPaddingPreview() {
    ComposeWeek2Theme {
        Text("Hi there!", Modifier.padding(top = 24.dp))
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    ComposeWeek2Theme {
        LayoutsCodelab()
    }
}


