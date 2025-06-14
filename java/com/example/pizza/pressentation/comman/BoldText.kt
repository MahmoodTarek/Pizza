package com.example.pizza.pressentation.comman

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BoldText(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        text = text ,
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Black,
        modifier = modifier
    )
}