package com.example.pizza.pressentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizza.pressentation.composable.PizzaScreen
import com.example.pizza.pressentation.composable.TopBar

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 60.dp)
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(32.dp))
        PizzaScreen()
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}