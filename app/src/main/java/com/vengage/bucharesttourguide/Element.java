package com.vengage.bucharesttourguide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vengage on 6/21/2017.
 * <p>
 * Class that describes a list element: Event, restaurant, historical site, shooping center
 */

class Element implements Parcelable{

    // The title of the element
    private String mTitle;

    // The address of the element
    private String mAddress;

    // The corresponding image id
    private int mImageId;

    // The location coordinates
    private double mLatitude;
    private double mLongitude;

    // The corresponding text description id
    private int mDescriptionID;

    Element(String mTitle, String mAddress, int mImageId, double mLatitude, double mLongitude, int mDescriptionID) {
        this.mTitle = mTitle;
        this.mAddress = mAddress;
        this.mImageId = mImageId;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
        this.mDescriptionID = mDescriptionID;
    }

    protected Element(Parcel in) {
        mTitle = in.readString();
        mAddress = in.readString();
        mImageId = in.readInt();
        mLatitude = in.readDouble();
        mLongitude = in.readDouble();
        mDescriptionID = in.readInt();
    }

    public static final Creator<Element> CREATOR = new Creator<Element>() {
        @Override
        public Element createFromParcel(Parcel in) {
            return new Element(in);
        }

        @Override
        public Element[] newArray(int size) {
            return new Element[size];
        }
    };

    String getmTitle() {
        return mTitle;
    }

    String getmAddress() {
        return mAddress;
    }

    int getmImageId() {
        return mImageId;
    }

    double getmLatitude() {
        return mLatitude;
    }

    double getmLongitude() {
        return mLongitude;
    }

    int getmDescriptionID() {
        return mDescriptionID;
    }

    @Override
    public String toString() {
        return "Element{" +
                "mTitle='" + mTitle + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mImageId=" + mImageId +
                ", mLatitude=" + mLatitude +
                ", mLongitude=" + mLongitude +
                ", mDescriptionID=" + mDescriptionID +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mAddress);
        parcel.writeInt(mImageId);
        parcel.writeDouble(mLatitude);
        parcel.writeDouble(mLongitude);
        parcel.writeInt(mDescriptionID);
    }
}
