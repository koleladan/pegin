package com.compose.pegination.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.compose.pegination.domain.model.Beers

@Composable
fun BeersItem(
    beers: Beers,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = beers.image_url ,
                contentDescription = beers.name,
                modifier = Modifier
                    .weight(1f)
                    //1f because the image is about 25% of the card
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            //3f because the text side occupies about 75% of the card's space
            ) {
                Text(
                    text = beers.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beers.tagline,
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beers.description,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "First brewed in ${beers.first_brewed}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 8.sp
                )

            }

        }

    }

}