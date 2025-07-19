package com.pomaskin.artists.presentation.biography

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextOverflow
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
fun BiographyScreen(
    onButtonBackClick: () -> Unit
) {
    val component = getApplicationComponent()
    val viewModel: BiographyViewModel = viewModel(factory = component.getViewModelFactory())
    val screenState = viewModel.state.collectAsState(BiographyScreenState.Initial)

    BiographyScreenContent(
        viewModel = viewModel,
        screenState = screenState,
        onButtonBackClick = onButtonBackClick
    )
}

@Composable
fun BiographyScreenContent(
    viewModel: BiographyViewModel,
    screenState: State<BiographyScreenState>,
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
            text = stringResource(R.string.biography_label)
        )
        Column {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = artistName,
                onValueChange = { artistName = it },
                label = { Text(stringResource(R.string.biography_find)) },
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
            BiographyData(screenState)
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
fun BiographyData(
    screenState: State<BiographyScreenState>
) {
    when (val state = screenState.value) {
        is BiographyScreenState.Initial -> {}

        is BiographyScreenState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = GradientLineStart)
            }
        }

        is BiographyScreenState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string.error))
            }
        }

        is BiographyScreenState.Content -> {
            val artist = state.artist
            val imageUrl = artist.imageUrl
            val name = artist.name
            val bioShort = artist.content

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 64.dp)
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Track Image",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = name,
                    style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = bioShort,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 20.sp,
                    )
                )
            }
        }
    }
}