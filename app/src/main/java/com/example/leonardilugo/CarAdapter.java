package com.example.leonardilugo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends ArrayAdapter<String[]> {
    int gid;
    List<String[]> items;
    Context context;


    public CarAdapter(@NonNull Context context, int resource, int id, ArrayList<String[]> items) {
        super(context, resource, id, items);
        this.context = context;
        gid = resource;
        this.items = items;
    }

    static class ViewHolder{
        public TextView fname;
        public TextView email;
        public TextView country;
        public TextView car_make;
        public TextView gender_co;
        public TextView job_title;
        public TextView bio;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if (rowView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(gid, parent, false);
            ViewHolder viewHolder = new ViewHolder();


            viewHolder.fname = (TextView) rowView.findViewById(R.id.full_nm);
            viewHolder.email = (TextView) rowView.findViewById(R.id.email);
            viewHolder.country = (TextView) rowView.findViewById(R.id.country);
            viewHolder.car_make = (TextView) rowView.findViewById(R.id.car_mke);
            viewHolder.gender_co = (TextView) rowView.findViewById(R.id.gender_co);
            viewHolder.job_title = (TextView) rowView.findViewById(R.id.job_title);
            viewHolder.bio = (TextView) rowView.findViewById(R.id.bio);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        String[] row = items.get(position);

        holder.fname.setText("Full Name: "+row[1]+ " "+ row[2]);
        holder.email.setText("Email: "+row[3]);
        holder.country.setText("Country: "+row[4]);
        holder.car_make.setText("Car Make, Color and Year: "+row[5]+ " "+ row[7]+" "+ row[6]);
        holder.gender_co.setText("Gender: "+row[8]);
        holder.job_title.setText("Job Title: "+row[9]);
        holder.bio.setText("Bio: "+row[10]);
        return rowView;
    }

}

