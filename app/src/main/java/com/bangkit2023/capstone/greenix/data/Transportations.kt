package com.bangkit2023.capstone.greenix.data

class Transportations(
    val name: String,
    val carbon: Float
)

object Transportation{
    val listTransportations = listOf(
        Transportations(
        "Car",
        0.142F
    ),
        Transportations(
            "Motorcycle",
            0.103F
        ),
        Transportations(
            "Bus",
            1.30F
        ))
}