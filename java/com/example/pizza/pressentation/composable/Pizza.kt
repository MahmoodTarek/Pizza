package com.example.pizza.pressentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza.R
import com.example.pizza.pressentation.comman.BoldText
import com.example.pizza.pressentation.comman.PizzaSizeButtonTemplate

@Composable
fun PizzaScreen() {
    val pageCount = 4
    val pizzaState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { pageCount }
    )
    val selectedIngredients = remember { mutableStateListOf<Int>() }
    LaunchedEffect(pizzaState.currentPage) { selectedIngredients.clear() }
    var selectedSize by remember { mutableStateOf("S") }
    PizzaContent(pizzaState, selectedIngredients, selectedSize) {
        selectedSize = it
    }
}

@Composable
fun PizzaContent(
    pizzaState: PagerState,
    selectedIngredients: SnapshotStateList<Int>,
    selectedSize: String,
    onSizeSelected: (String) -> Unit
) {
    val pizzaSize = when (selectedSize) {
        "S" -> 180.dp
        "M" -> 200.dp
        else -> 220.dp
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.plate),
                contentDescription = "plate",
                modifier = Modifier.size(250.dp)
            )

            HorizontalPager(
                state = pizzaState,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically
            ) { page ->
                val imageId = when (page) {
                    0 -> R.drawable.bread_1
                    1 -> R.drawable.bread_2
                    2 -> R.drawable.bread_3
                    3 -> R.drawable.bread_4
                    else -> R.drawable.bread_5
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(imageId),
                        contentDescription = null,
                        modifier = Modifier.size(pizzaSize)
                    )
                }
            }

            selectedIngredients.forEach { ingredient ->
                Box(
                    modifier = Modifier
                        .size(pizzaSize)
                        .align(Alignment.Center)
                ) {
                    PizzaToppingLayer(ingredientImage = ingredient,pizzaSize)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        BoldText("$17", modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            listOf("S", "M", "L").forEach { pizzaSize ->
                PizzaSizeButtonTemplate(
                    text = pizzaSize,
                    isSelected = pizzaSize == selectedSize,
                    onClick = { onSizeSelected(pizzaSize) }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray,
            modifier = Modifier.align(alignment = Alignment.Start).padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.height(22.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf(
                R.drawable.basil_3,
                R.drawable.onion_3,
                R.drawable.broccoli_1,
                R.drawable.mushroom_6,
                R.drawable.sausage_1
            ).forEach { ingredient ->
                item {
                    CustomizeIngredient(
                        ingredientImage = ingredient,
                        onClick = {
                            if (selectedIngredients.contains(ingredient)) {
                                selectedIngredients.remove(ingredient)
                            } else {
                                selectedIngredients.add(ingredient)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(52.dp))

        AddToCard(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

    }
}

@Preview
@Composable
fun PizzaPreview() {
    PizzaScreen()
}
