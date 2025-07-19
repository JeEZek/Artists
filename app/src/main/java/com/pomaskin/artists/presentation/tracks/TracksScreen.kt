package com.pomaskin.artists.presentation.tracks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.pomaskin.artists.R
import com.pomaskin.artists.presentation.getApplicationComponent
import com.pomaskin.artists.ui.components.GradientButton
import com.pomaskin.artists.ui.components.GradientLine
import com.pomaskin.artists.ui.theme.GradientButton1End
import com.pomaskin.artists.ui.theme.GradientButton1Start
import com.pomaskin.artists.ui.theme.GradientLineEnd
import com.pomaskin.artists.ui.theme.GradientLineStart

@Composable
fun TracksScreen(
    onButtonBackClick: () -> Unit
) {
    val component = getApplicationComponent()
    val viewModel: TracksViewModel = viewModel(factory = component.getViewModelFactory())
    val screenState = viewModel.state.collectAsState(TracksScreenState.Initial)

    TrackScreenContent(
        viewModel = viewModel,
        screenState = screenState,
        onButtonBackClick = onButtonBackClick
    )
}

@Composable
fun TrackScreenContent(
    viewModel: TracksViewModel,
    screenState: State<TracksScreenState>,
    onButtonBackClick: () -> Unit,
) {
    var artistName by remember { mutableStateOf("") }

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
                value = artistName,
                onValueChange = { artistName = it },
                label = { stringResource(R.string.tracks_find) },
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
            onClick = {
                viewModel.onLoadButtonClick(artistName)
            },
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            TracksData(screenState = screenState)
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .clickable(
                    onClick = {
                        viewModel.resetState()
                        onButtonBackClick()
                    }
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
fun TracksData(
    screenState: State<TracksScreenState>,
) {
    when (val state = screenState.value) {
        is TracksScreenState.Initial -> {}

        is TracksScreenState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = GradientLineStart)
            }
        }

        is TracksScreenState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string.error))
            }
        }

        is TracksScreenState.Content -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                val tracks = state.tracks
                for (track in tracks) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        AsyncImage(
                            model = track.imageUrl,
                            contentDescription = "Track Image",
                            modifier = Modifier
                                .size(96.dp)
                        )
                        Spacer(modifier = Modifier.width(32.dp))
                        Text(
                            text = track.name,
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}