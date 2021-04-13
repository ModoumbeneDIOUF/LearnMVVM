package com.bichri.yewou.model

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class ContentX(
    var amountCollectedInCents: Int,
    var amountToBeRaisedInCents: Int,
    var createdAt: String?,
    var datetimeLimit: String?,
    var description: String?,
    var documentUrls: ArrayList<String>?,
    var economicDimensionInPercent: Int,
    var environmentalDimensionInPercent: Int,
    var id: Int,
    var links: List<Link>,
    var objectives: String?,
    var packItems: List<PackItem>,
    var socialDimensionInPercent: Int,
    var title: String?,
    var updatedAt: String?,
    var version: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        TODO("links"),
        parcel.readString(),
        TODO("packItems"),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(amountCollectedInCents)
        parcel.writeInt(amountToBeRaisedInCents)
        parcel.writeString(createdAt)
        parcel.writeString(datetimeLimit)
        parcel.writeString(description)
        parcel.writeStringList(documentUrls)
        parcel.writeInt(economicDimensionInPercent)
        parcel.writeInt(environmentalDimensionInPercent)
        parcel.writeInt(id)
        parcel.writeString(objectives)
        parcel.writeInt(socialDimensionInPercent)
        parcel.writeString(title)
        parcel.writeString(updatedAt)
        parcel.writeInt(version)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContentX> {
        override fun createFromParcel(parcel: Parcel): ContentX {
            return ContentX(parcel)
        }

        override fun newArray(size: Int): Array<ContentX?> {
            return arrayOfNulls(size)
        }
    }
}