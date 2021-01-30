package com.flawlessconcepts.retrofitdemo.albums

import java.util.*

data class BookingItem(
    val arrivalTime: String,
    val bookingDate: String,
    val bookingID: Int,
    val bookingStatus: String,
    val calculatedCost: Double,
    val customerID: String,
    val departureTime: String,
    val destination: String,
    val location: String,
    val locationAddress: String,
    val numbOfPassengers: Int,
    val paidAmount: Double,
    val paymentStatus: String,
    val tripDistance: Double,
    val vehicleID: String
)

