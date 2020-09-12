package com.example.leonardilugo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Range;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    private List<Product> products;
    private String start_yr_checker;
    private String gender_checker;
    private ArrayList<String> country_checker, color_checker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        toolbar = findViewById(R.id.toolbar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        Call repos = service.getPosts();
        repos.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                products = response.body();
                listView.setAdapter(new Adapter(getApplicationContext(), products));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, Car_Owners.class);
                        intent.putExtra("Product", listView.getItemAtPosition(position).toString());
                        intent.putExtra("gender_checker", gender_checker);
                        intent.putExtra("start_year_checker", start_yr_checker);
                        intent.putStringArrayListExtra("country_checker", country_checker);
                        intent.putStringArrayListExtra("color_checker", color_checker);

                        startActivity(intent);

                        Product product = products.get(position);

                        start_yr_checker = new Range<Integer>(product.getStart_year(), product.getEnd_year()).toString();
                        gender_checker = product.getGender();
                        country_checker = new ArrayList<>(product.getCountries());
                        color_checker = new ArrayList<>(product.getColors());


                    }
                });
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
