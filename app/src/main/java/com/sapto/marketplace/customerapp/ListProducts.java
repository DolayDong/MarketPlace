package com.sapto.marketplace.customerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sapto.marketplace.customerapp.classModel.ListProduct;
import com.sapto.marketplace.customerapp.classModel.Product;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListProducts extends AppCompatActivity {

    RecyclerView recylerView;
    final MyAdapter myAdapter = new MyAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);
        inisialisasiElement();
        VolleyLoad();
    }

    public  void inisialisasiElement(){
        recylerView = findViewById(R.id.home_rv);

    }

    public void VolleyLoad(){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http://210.210.154.65:4444/api/products";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Gson gson = new Gson();
                            ListProduct listProduct = gson.fromJson(response.toString(), ListProduct.class);
                            ArrayList<Product> data = new ArrayList<>(listProduct.getProducts());

                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListProducts.this);
                            recylerView.setLayoutManager(layoutManager);
                            recylerView.setAdapter(myAdapter);
                            myAdapter.addData(data);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ListProducts.this, "Volley Error", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
        requestQueue.add(request);
    }
}
