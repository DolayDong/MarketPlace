package com.sapto.marketplace.customerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sapto.marketplace.customerapp.classModel.Product;

public class DetailProduct extends AppCompatActivity {
    ImageView image;
    TextView tvDetailIdProduct, tvDetailNamaProduct, tvDetailSlugProduct, tvDetailQuantity, tvDetailMerchantId, tvDetailMerchantNama, tvDetailMerchantSlug, tvDetailCategoryId, tvDetailCategotyNama;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        Bundle bundle = getIntent().getExtras();
        String json = null;
        if (bundle != null) {
            json = bundle.getString("data");
        }

        Product product = new Gson().fromJson(json, Product.class);

        inisialisasiElement();
String baseUrl = "http://210.210.154.65:4444/storage/";
String url = baseUrl+product.getProductImage();
        Glide.with(this).load("http://210.210.154.65:4444/storage/images/products/product_image_1280x780.png").into(image);

tvDetailIdProduct.setText("ID Product : " + product.getProductId());
tvDetailNamaProduct.setText("Nama Product : " + product.getProductNama());
tvDetailSlugProduct.setText("Slug Product : " + product.getProductSlug());
tvDetailQuantity.setText("Quantity Product : " + product.getProductQty());
tvDetailMerchantId.setText("Merchant ID : " + product.getMerchants().getMerchantId());
tvDetailMerchantNama.setText("Nama Merchant : " + product.getMerchants().getMerchantName());
tvDetailMerchantSlug.setText("Merchant Slug : " + product.getMerchants().getMerchantSlug());
tvDetailCategoryId.setText("Category ID : " + String.valueOf(product.getCategorys().getCategoryId()));
tvDetailCategotyNama.setText("Nama Category : " + product.getCategorys().getCategoryName());
    }

    public void inisialisasiElement(){
        image = findViewById(R.id.detail_image_view);
        tvDetailIdProduct = findViewById(R.id.tv_detail_id);
        tvDetailNamaProduct =  findViewById(R.id.tv_detail_nama);
        tvDetailSlugProduct = findViewById(R.id.tv_detail_slug);
        tvDetailMerchantId = findViewById(R.id.tv_detail_merchant_id);
        tvDetailMerchantNama = findViewById(R.id.tv_detail_merchant_name);
        tvDetailMerchantSlug =  findViewById(R.id.tv_detail_merchant_slug);
        tvDetailCategoryId = findViewById(R.id.tv_detail_category_id);
        tvDetailCategotyNama = findViewById(R.id.tv_detail_category_name);
        tvDetailQuantity = findViewById(R.id.tv_detail_quantity);
    }
}
