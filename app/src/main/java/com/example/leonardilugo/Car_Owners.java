package com.example.leonardilugo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.util.Range;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Car_Owners extends AppCompatActivity {

    private String gender_checker, start_year_checker;
    private ArrayList<String> country_checker, color_checker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car__owners);

        InputStream inputStream = getResources().openRawResource(R.raw.car_ownsers_data);

        CSVFile csvFile = new CSVFile(inputStream);
        ArrayList<String[]> owners = csvFile.read();
        CarAdapter carAdapter = new CarAdapter(this,R.layout.car_owners_layout, R.id.full_nm, owners);
        ListView listView2 = (ListView) findViewById(R.id.listView2);
        listView2.setAdapter(carAdapter);


        gender_checker = getIntent().getStringExtra("gender_checker");
        start_year_checker = getIntent().getStringExtra("start_year_checker");
        color_checker = getIntent().getStringArrayListExtra("color_checker");
        country_checker = getIntent().getStringArrayListExtra("country_checker");

    }


    public class CSVFile {
        InputStream inputStream;

        public CSVFile(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public ArrayList<String[]> read() {
            ArrayList<String[]> resultList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            try {

                String line;
                int it = 0;
                while ((line = reader.readLine()) != null) {
                    if (it == 0) {
                        it++;
                        continue;
                    }

                    String[] row = line.split(",");
                    /*String yearVal = row[6];
                    String genderVal = row[8];
                    String countryVal = row[4];
                    String colorVal = row[7];

                    if  (yearVal.equals(start_year_checker) ||genderVal.equals(gender_checker) || (countryVal.equals(country_checker) || (colorVal.equals(color_checker)))) {
                      */  resultList.add(row);


                }
            } catch (IOException e) {
                Log.e("Main", e.getMessage());
            }
            return resultList;
        }

    }
}

