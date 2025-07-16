package com.pomaskin.artists.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pomaskin.artists.R
import com.pomaskin.artists.ui.components.GradientButton
import com.pomaskin.artists.ui.components.GradientLine
import com.pomaskin.artists.ui.theme.GradientButton1End
import com.pomaskin.artists.ui.theme.GradientButton1Start
import com.pomaskin.artists.ui.theme.GradientButton2End
import com.pomaskin.artists.ui.theme.GradientButton2Start
import com.pomaskin.artists.ui.theme.GradientLineEnd
import com.pomaskin.artists.ui.theme.GradientLineStart

@Composable
fun MainScreen(
    onButtonBiographyClick: () -> Unit,
    onButtonTracksClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 64.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp),
            style = TextStyle(
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            ),
            text = stringResource(R.string.main_label)
        )
        GradientLine(
            modifier = Modifier
                .padding(horizontal = 32.dp),
            gradient = Brush.horizontalGradient(listOf(GradientLineStart, GradientLineEnd))
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp),
            style = TextStyle(
                fontSize = 20.sp
            ),
            text = stringResource(R.string.main_label_2)
        )
        //TODO image to xml
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),

            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.main_picture),
            contentDescription = null
        )
        GradientButton(
            text = stringResource(R.string.main_button_biography),
            gradient = Brush.horizontalGradient(listOf(GradientButton1Start, GradientButton1End)),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .padding(horizontal = 32.dp),
            onClick = onButtonBiographyClick,
        )
        GradientButton(
            text = stringResource(R.string.main_button_tracks),
            gradient = Brush.horizontalGradient(listOf(GradientButton2Start, GradientButton2End)),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .padding(horizontal = 32.dp),
            onClick = onButtonTracksClick,
        )
    }
}
