package com.sapto.marketplace.customerapp.classModel;

import android.os.Parcel;
import android.os.Parcelable;

public class Merchant implements Parcelable {
    private int merchantId;
    private String merchantName;

    private String merchantSlug;

    public Merchant(int merchantId, String merchantName, String merchantSlug) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.merchantSlug = merchantSlug;
    }

    private Merchant(Parcel in) {
        merchantId = in.readInt();
        merchantName = in.readString();
        merchantSlug = in.readString();
    }

    public static final Creator<Merchant> CREATOR = new Creator<Merchant>() {
        @Override
        public Merchant createFromParcel(Parcel in) {
            return new Merchant(in);
        }

        @Override
        public Merchant[] newArray(int size) {
            return new Merchant[size];
        }
    };

    public int getMerchantId() {
        return merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getMerchantSlug() {
        return merchantSlug;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(merchantId);
        dest.writeString(merchantName);
        dest.writeString(merchantSlug);
    }



}
