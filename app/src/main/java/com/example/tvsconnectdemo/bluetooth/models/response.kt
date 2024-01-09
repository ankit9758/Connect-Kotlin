package com.example.tvsconnectdemo.bluetooth.models

import android.bluetooth.BluetoothDevice

data class BluetoothModel(
    private val state: String? = null,
    private val bluetoothDevice: BluetoothDevice? = null
)