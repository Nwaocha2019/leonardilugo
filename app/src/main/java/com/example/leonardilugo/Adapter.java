package com.example.leonardilugo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Adapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> products;

    public Adapter (Context context, List<Product> products){
        super(context, R.layout.product_rows_layout, products);
        this.context = context;
        this.products = products;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.product_rows_layout, parent, false);

            Product product = products.get(position);

            TextView date_range = (TextView) convertView.findViewById(R.id.date_range);
            date_range.setText("Date Range: " + product.getStart_year() + "-" + (product.getEnd_year()));

            TextView gender = (TextView) convertView.findViewById(R.id.gender);
            if (product.getGender() == null  || product.getGender().isEmpty()){
                gender.setText("Gender: ALL");
            }
            else{ gender.setText("Gender: " + product.getGender()); }

            TextView countries = (TextView) convertView.findViewById(R.id.countries);
            if (product.getCountries()==null || product.getCountries().isEmpty()){
                countries.setText("Countries: " + product.getCountries().toString().replace("[","ALL").replace("]",""));
            }
            else {
                countries.setText("Countries: " + product.getCountries().toString().replace("[","").replace("]",""));
            }

            TextView color = (TextView) convertView.findViewById(R.id.color);
            if (product.getColors()==null  || product.getColors().isEmpty()) {
                color.setText("Color: "+ product.getColors().toString().replace("[","ALL").replace("]",""));
            }
            else {color.setText("Color: "+ product.getColors().toString().replace("[","").replace("]",""));}

            return convertView;
        }



}
