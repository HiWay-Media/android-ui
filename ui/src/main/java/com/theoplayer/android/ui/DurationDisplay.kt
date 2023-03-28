package com.theoplayer.android.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * A text display that shows the player's duration.
 *
 * @param modifier the [Modifier] to be applied to this text
 */
@Composable
fun DurationDisplay(
    modifier: Modifier = Modifier
) {
    val state = LocalTHEOplayer.current
    val duration = state?.duration ?: Double.NaN

    Text(modifier = modifier, text = formatTime(duration))
}