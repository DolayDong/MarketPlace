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
    TextView tvDetailNamaProduct, tvDetailHarga, tvDetailDeskripsi, tvDetailSlugProduct, tvDetailQuantity, tvDetailMerchantNama, tvDetailMerchantSlug, tvDetailCategotyNama;

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
        Glide.with(this).load(url).into(image);

tvDetailNamaProduct.setText(product.getProductNama());
tvDetailHarga.setText("Rp. " + product.getProductPrice());
tvDetailSlugProduct.setText("Slug Product : " + product.getProductSlug());
tvDetailQuantity.setText("Quantity : " + product.getProductQty());
tvDetailDeskripsi.setText("Deskripsi : " + product.getProductDesc());
tvDetailMerchantNama.setText("Nama Merchant : " + product.getMerchants().getMerchantName());
tvDetailMerchantSlug.setText("Merchant Slug : " + product.getMerchants().getMerchantSlug());
tvDetailCategotyNama.setText("Nama Category : " + product.getCategorys().getCategoryName());
    }

    public void inisialisasiElement(){
        image = findViewById(R.id.detail_image_view);
        tvDetailDeskripsi = findViewById(R.id.tv_deskripsi);
        tvDetailHarga = findViewById(R.id.tv_harga);
        tvDetailNamaProduct =  findViewById(R.id.tv_detail_nama);
        tvDetailSlugProduct = findViewById(R.id.tv_detail_slug);
        tvDetailMerchantNama = findViewById(R.id.tv_detail_merchant_name);
        tvDetailMerchantSlug =  findViewById(R.id.tv_detail_merchant_slug);
        tvDetailCategotyNama = findViewById(R.id.tv_detail_category_name);
        tvDetailQuantity = findViewById(R.id.tv_detail_quantity);
    }
}
