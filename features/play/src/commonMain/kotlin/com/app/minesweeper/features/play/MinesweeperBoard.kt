package com.app.minesweeper.features.play

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import minesweeper.features.play.generated.resources.Res
import minesweeper.features.play.generated.resources.mine
import org.jetbrains.compose.resources.painterResource

@Composable
fun Tile(
    state: TileState,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color = LocalMinesweeperBoardColorScheme.current.background)
    ) {
        when (state) {
            is TileState.Hidden -> {
                if (state.flagged) {
                    Icon(
                        imageVector = Icons.Filled.Flag,
                        contentDescription = null,
                        tint = LocalMinesweeperBoardColorScheme.current.flag,
                        modifier = Modifier.fillMaxSize(fraction = 0.6f)
                    )
                }
            }
            TileState.Revealed.Mine -> {
                Icon(
                    painter = painterResource(Res.drawable.mine),
                    contentDescription = null,
                    tint = LocalMinesweeperBoardColorScheme.current.mine,
                    modifier = Modifier.fillMaxSize(fraction = 0.6f)
                )
            }
            is TileState.Revealed.Number -> {
                state.value?.let { number ->
                    val color: Color = when(number) {
                        1 -> LocalMinesweeperBoardColorScheme.current.one
                        2 -> LocalMinesweeperBoardColorScheme.current.two
                        3 -> LocalMinesweeperBoardColorScheme.current.three
                        4 -> LocalMinesweeperBoardColorScheme.current.four
                        5 -> LocalMinesweeperBoardColorScheme.current.five
                        6 -> LocalMinesweeperBoardColorScheme.current.six
                        7 -> LocalMinesweeperBoardColorScheme.current.seven
                        8 -> LocalMinesweeperBoardColorScheme.current.eight
                        else -> Color.Black
                    }
                    Text(
                        text = number.toString(),
                        textAlign = TextAlign.Center,
                        color = color,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(
                                align = Alignment.CenterVertically,
                            )
                    )
                }
            }
        }
    }
}

@Immutable
data class MinesweeperBoardColorScheme(
    val background: Color,
    val borderLight: Color,
    val borderDark: Color,
    val mine: Color,
    val flag: Color,
    val one: Color,
    val two: Color,
    val three: Color,
    val four: Color,
    val five: Color,
    val six: Color,
    val seven: Color,
    val eight: Color,
    val timerText: Color,
)

internal val LocalMinesweeperBoardColorScheme : ProvidableCompositionLocal<MinesweeperBoardColorScheme> = compositionLocalOf {
    MinesweeperBoardColorScheme(
        background = Color(0xFFCBCBCB),
        borderLight = Color(0xFFFFFFFF),
        borderDark = Color(0xFF8F8F8F),
        mine = Color(0xFF000000),
        flag = Color(0xFFEB392A),
        one = Color(0xFF0000F5),
        two = Color(0xFF377E22),
        three = Color(0xFFFA3323),
        four = Color(0xFF00007B),
        five = Color(0xFF75140C),
        six = Color(0xFF377E7F),
        seven = Color(0xFF75147C),
        eight = Color(0xFF808080),
        timerText = Color(0xFFEA3324),
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun TilesPreview() {
    val states: Set<TileState> = getPossibleTileStates()

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        states.forEach { state ->
            Tile(
                state = state,
                modifier = Modifier.size(32.dp),
            )
        }
    }
}

private fun getPossibleTileStates(): Set<TileState> = setOf(
    TileState.Hidden(flagged = false),
    TileState.Hidden(flagged = true),
    TileState.Revealed.Number(null),
    TileState.Revealed.Number(1),
    TileState.Revealed.Number(2),
    TileState.Revealed.Number(3),
    TileState.Revealed.Number(4),
    TileState.Revealed.Number(5),
    TileState.Revealed.Number(6),
    TileState.Revealed.Number(7),
    TileState.Revealed.Number(8),
)