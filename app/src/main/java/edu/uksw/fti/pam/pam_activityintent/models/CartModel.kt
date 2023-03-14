package edu.uksw.fti.pam.pam_activityintent.models

import com.google.gson.annotations.SerializedName

data class CartModel(
    @SerializedName("gambar")
    var gambar: String,

    @SerializedName("judul")
    var judul: String,

    @SerializedName("harga")
    var harga: String,

    @SerializedName("hargadis")
    var hargadis:String

    )
