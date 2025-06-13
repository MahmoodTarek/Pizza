package com.example.pizza.pressentation.composable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun PizzaToppingLayer(
    ingredientImage: Int,
    pizzaSize: Dp
) {
    val sizePx = with(LocalDensity.current) { pizzaSize.toPx() }

    val positions = remember {
        List(20) {
            val angle = Random.nextFloat() * 360f
            val radius = Random.nextFloat() * (sizePx / 2 - 32)
            val x = cos(Math.toRadians(angle.toDouble())).toFloat() * radius
            val y = sin(Math.toRadians(angle.toDouble())).toFloat() * radius
            Offset(x, y)
        }
    }

    Box(
        modifier = Modifier.size(pizzaSize)
    ) {
        positions.forEachIndexed { index, offset ->

            val alpha = remember { Animatable(0f) }

            LaunchedEffect(Unit) {
                delay(index * 70L)
                alpha.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = 600)
                )
            }

            Image(
                painter = painterResource(ingredientImage),
                contentDescription = null,
                modifier = Modifier
                    .size(18.dp)
                    .align(Alignment.Center)
                    .offset {
                        IntOffset(offset.x.toInt(), offset.y.toInt())
                    }
                    .alpha(alpha.value)
            )
        }
    }
}
