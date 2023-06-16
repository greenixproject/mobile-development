package com.bangkit2023.capstone.greenix.data

class Foods(
    val name: String,
    val carbon: Float
)

object Food{
    val listFoods = listOf(Foods(
        "Oil",
        12F
    ),
        Foods(
            "Rice",
            8.8F
        ),
        Foods(
            "Meat",
            20.1F
        ))
}