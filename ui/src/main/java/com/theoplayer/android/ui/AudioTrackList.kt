package com.theoplayer.android.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AudioTrackList(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val state = LocalTHEOplayer.current
    val audioTracks = state?.audioTracks ?: listOf()
    val activeAudioTrack = state?.activeAudioTrack
    LazyColumn(modifier = modifier) {
        items(
            count = audioTracks.size,
            key = { audioTracks[it].uid }
        ) {
            val audioTrack = audioTracks[it]
            ListItem(
                headlineText = { Text(text = formatTrackLabel(audioTrack)) },
                leadingContent = {
                    RadioButton(
                        selected = (activeAudioTrack == audioTrack),
                        onClick = null
                    )
                },
                modifier = Modifier.clickable(onClick = {
                    state?.activeAudioTrack = audioTrack
                    onClick?.let { it() }
                })
            )
        }
    }
}