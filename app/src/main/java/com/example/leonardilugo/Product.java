package com.example.leonardilugo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Product  {

        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("start_year")
        @Expose
        private int start_year;

        @SerializedName("end_year")
        @Expose
        private int end_year;

        @SerializedName("gender")
        private String gender;

        @SerializedName("countries")
        private List<String> countries;

        @SerializedName("colors")
        private   List<String> colors;

        public String getId() {
                return id;
        }

        public int getStart_year() {
                return start_year;
        }

        public int getEnd_year() {
                return end_year;
        }

        public String getGender() {
                return gender;
        }

        public List<String> getCountries() { return countries;
        }

        public List<String> getColors() {
                return colors;
        }


        public void setId(String id) {
                this.id = id;
        }

        public void setStart_year(int start_year) {
                this.start_year = start_year;
        }

        public void setEnd_year(int end_year) {
                this.end_year = end_year;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public void setCountries(List<String> countries) {
                this.countries = countries;
        }

        public void setColors(List<String> colors) {
                this.colors = colors;
        }

        String json ="";
        Gson gson = new GsonBuilder().serializeNulls().create();
        Product product = gson.fromJson(json, Product.class);
}

