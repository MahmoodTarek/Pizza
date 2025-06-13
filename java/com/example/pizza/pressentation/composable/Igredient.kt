package com.example.pizza.pressentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizza.ui.theme.BgGreen


@Composable
fun CustomizeIngredient(
    modifier: Modifier = Modifier,
    ingredientImage: Int,
    onClick: (Int) -> Unit
) {
    var isSelected by remember { mutableStateOf(false) }
    Button(
        onClick = {
            isSelected = !isSelected
            onClick(ingredientImage)
        },
        modifier = modifier.size(70.dp),
        shape = CircleShape,
        colors = if (isSelected)
            ButtonDefaults.buttonColors(containerColor = BgGreen)
        else
            ButtonDefaults.buttonColors(containerColor = White),
        contentPadding = PaddingValues(0.dp),
    ) {
        Image(
            painter = painterResource(ingredientImage),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .padding(12.dp)
        )
    }
}