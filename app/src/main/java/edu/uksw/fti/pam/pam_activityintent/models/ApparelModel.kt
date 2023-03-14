package edu.uksw.fti.pam.pam_activityintent.models

import com.google.gson.annotations.SerializedName

data class ApparelModel(
    @SerializedName("judul")
    var judul: String,

    @SerializedName("harga")
    var harga: String,

    @SerializedName("gambar")
    var gambar: String

    )
