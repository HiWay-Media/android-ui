package com.theoplayer.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

typealias MenuContent = @Composable MenuScope.() -> Unit;

@Composable
fun MenuScope.Menu(
    title: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(
                shape = IconButtonDefaults.filledShape,
                onClick = { closeCurrentMenu() }
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back"
                )
            }
            title()
        }
        content()
    }
}

interface MenuScope {
    fun openMenu(menu: MenuContent)

    fun closeCurrentMenu()
}