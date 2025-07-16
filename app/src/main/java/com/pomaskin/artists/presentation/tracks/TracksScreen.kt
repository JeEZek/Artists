package com.pomaskin.artists.presentation.tracks

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pomaskin.artists.R
import com.pomaskin.artists.ui.components.GradientButton
import com.pomaskin.artists.ui.components.GradientLine
import com.pomaskin.artists.ui.theme.GradientButton1End
import com.pomaskin.artists.ui.theme.GradientButton1Start
import com.pomaskin.artists.ui.theme.GradientLineEnd
import com.pomaskin.artists.ui.theme.GradientLineStart

@Composable
fun TracksScreen(
    onButtonFindClick: (String) -> Unit,
    onButtonBackClick: () -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 64.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            style = TextStyle(
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            ),
            text = stringResource(R.string.tracks_label)
        )
        Column {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchText,
                onValueChange = { searchText = it },
                label = { stringResource(R.string.tracks_find)  },
                singleLine = true,
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
                keyboardOptions = KeyboardOptions.Default,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                )
            )
            GradientLine(
                gradient = Brush.horizontalGradient(listOf(GradientLineStart, GradientLineEnd))
            )
        }
        GradientButton(
            text = stringResource(R.string.button_find),
            gradient = Brush.horizontalGradient(listOf(GradientButton1Start, GradientButton1End)),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .padding(horizontal = 68.dp),
            onClick = { onButtonFindClick(searchText) },
        )
        //TODO Box for data after searching
        Box(
            modifier = Modifier
                .background(Black)
                .fillMaxWidth()
                .weight(1f)
        ) {
            TracksData()
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .clickable(
                    onClick = { onButtonBackClick() }
                ),
            style = TextStyle(
                fontSize = 20.sp,
                textDecoration = TextDecoration.Underline
            ),
            text = stringResource(R.string.button_back)
        )
    }
}

@Composable
fun TracksData() {

}