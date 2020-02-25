package com.sapto.marketplace.customerapp.classModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable {
    private int productId;
    private int productQty;

    @SerializedName("productName")
    private String productNama;

    private String productSlug;
    private String productImage;

    @SerializedName("merchant")
    private Merchant merchants;

    @SerializedName("category")
    private Category categorys;

    public Product(int productId, int productQty, String productNama, String productSlug, String productImage, Merchant merchants, Category categorys) {
        this.productId = productId;
        this.productQty = productQty;
        this.productNama = productNama;
        this.productSlug = productSlug;
        this.productImage = productImage;
        this.merchants = merchants;
        this.categorys = categorys;
    }

    private Product(Parcel in) {
        productId = in.readInt();
        productQty = in.readInt();
        productNama = in.readString();
        productSlug = in.readString();
        productImage = in.readString();
        merchants = in.readParcelable(Merchant.class.getClassLoader());
        categorys = in.readParcelable(Category.class.getClassLoader());
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getProductId() {
        return productId;
    }

    public int getProductQty() {
        return productQty;
    }

    public String getProductNama() {
        return productNama;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public String getProductImage() {
        return productImage;
    }

    public Merchant getMerchants() {
        return merchants;
    }

    public Category getCategorys() {
        return categorys;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(productId);
        dest.writeInt(productQty);
        dest.writeString(productNama);
        dest.writeString(productSlug);
        dest.writeString(productImage);
        dest.writeParcelable(merchants, flags);
        dest.writeParcelable(categorys, flags);
    }
}
