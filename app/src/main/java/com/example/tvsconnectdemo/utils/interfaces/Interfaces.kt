package com.example.tvsconnectdemo.utils.interfaces

import android.graphics.Bitmap
import android.location.Location
import android.view.View
import com.example.tvsconnectdemo.bluetooth.models.BluetoothModel

interface DialogClickListener {
    fun onLocateFuelClick(view: View?)
    fun onCancelClick(view: View?)
}
interface FeedbackPopupListener {
    fun onCsiSubmit()
    fun onNpsSubmit()
    fun onCsiReschedule()
    fun onNpsReschedule()
}
interface FileDownloadReady {
    fun onFileDownloaded(rideDataModel: Any?, fileId: String?)
}

interface IMMINavigationListener {
    fun onAdviseInfoUpdated(adviseText1: String?, distanceToNextAdvise: Long,
        distanceLeft: Long, etaText: String?, maneuverID: Int,
        isRouteIsBeingCalculated: Boolean, uTurnSuggestion: Boolean,
        isOnRoute: Boolean, distanceFromRoute: Double, etaInSeconds: Int, info: Any?
    )
}
interface InterNetConnection {
    fun connectionCheck(check: Boolean, callingValue: Int)
}

interface IU399AlertDialogListener {
    fun onCancelClicked(view: View?, alertId: Int)
    fun onActionClicked(view: View?, alertId: Int)
}

interface IWaypointClickListener {
    fun onItemClickListener(position: Int)
}
interface LocationReceived {
    fun onLocationReceived(location: Location?)
}

interface OnBluetoothListItemClick {
    fun onItemClick(bluetoothModel: BluetoothModel?)
}
interface OnRadioClickListener {
    fun setOnClick(arg: Int)
}

interface OnResponseReceived {
    fun onResponse(response: Any?, count: Int)
    fun onError()
}
/*interface OnSelectBikeListener {
    fun onBikeSelected(v: View?, requestModel: AddVehicleRequestModel?, position: Int)
}*/
interface OnTrackChangeListener {
    fun onTrackChange(track: String?, bitmap: Bitmap?)
}
