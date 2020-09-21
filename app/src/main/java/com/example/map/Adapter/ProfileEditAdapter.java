package com.example.map.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.map.R;

import java.util.List;

public class ProfileEditAdapter extends RecyclerView.Adapter {

    private Context context;



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.profile_edit_row,parent,false);

        return new ProfileEditHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class  ProfileEditHolder extends RecyclerView.ViewHolder {
        public ProfileEditHolder(@NonNull View itemView) {
            super(itemView);


            //profileTitle = itemView.findViewById(R.id.txt_Profile_Info);


        }
    }
}
