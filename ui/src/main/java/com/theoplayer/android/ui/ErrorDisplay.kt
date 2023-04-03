package com.theoplayer.android.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A display for a fatal error, if the player encounters one.
 *
 * @param modifier the [Modifier] to be applied to this display
 */
@Composable
fun ErrorDisplay(
    modifier: Modifier = Modifier,
) {
    val error = PlayerState.current?.error

    error?.let { it ->
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column {
                Icon(
                    Icons.Rounded.Error,
                    modifier = Modifier.size(48.dp),
                    contentDescription = null
                )
            }
            Column {
                Box(
                    modifier = Modifier.defaultMinSize(minHeight = 48.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "An error occurred",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                Text(
                    text = "${it.message}"
                )
            }
        }
    }
}
