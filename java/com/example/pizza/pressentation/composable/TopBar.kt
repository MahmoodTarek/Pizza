package com.example.pizza.pressentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizza.R
import com.example.pizza.pressentation.comman.BoldText

@Composable
fun TopBar() {
    Row(
        Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .size(32.dp)
                .align(alignment = Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = "back Arrow",
                modifier = Modifier
                    .align(alignment = Alignment.CenterStart)
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
        ) {
            BoldText("Pizza", modifier = Modifier.align(alignment = Alignment.Center))
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .size(24.dp)
                .align(alignment = Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(R.drawable.heart),
                contentDescription = "favorite Dish",
                modifier = Modifier
                    .align(alignment = Alignment.CenterEnd)
            )
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}