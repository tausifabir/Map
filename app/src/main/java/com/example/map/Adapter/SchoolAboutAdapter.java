package com.example.map.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.map.R;

import java.util.List;

public class SchoolAboutAdapter extends RecyclerView.Adapter<SchoolAboutAdapter.SchoolAboutViewHolder> {

    private Context context;
    private List<AboutSchoolListModel> aboutSchoolList;

    public SchoolAboutAdapter(Context context, List<AboutSchoolListModel> aboutSchoolList) {
        this.context = context;
        this.aboutSchoolList = aboutSchoolList;
    }

    @NonNull
    @Override
    public SchoolAboutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_about_school, parent, false);
        return new SchoolAboutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolAboutViewHolder holder, int position) {

        final AboutSchoolListModel aboutSchoolListModel =aboutSchoolList.get(position);
        holder.schoolAbtTitle.setText(aboutSchoolListModel.getTitle());
        holder.schoolAbtDetails.setText(aboutSchoolListModel.getDetail());

/*        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SchoolDetailsActivity.class);
                intent.putExtra("detailsAbout","aboutUs");
                intent.putExtra("detailId",aboutSchoolListModel.getID());
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return aboutSchoolList.size();
    }

    public class SchoolAboutViewHolder extends RecyclerView.ViewHolder {

        private TextView schoolAbtTitle, schoolAbtDetails;

        public SchoolAboutViewHolder(@NonNull View itemView) {
            super(itemView);
            schoolAbtTitle = itemView.findViewById(R.id.about_title);
            schoolAbtDetails = itemView.findViewById(R.id.about_details);
        }
    }
}
