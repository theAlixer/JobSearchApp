package com.example.tristam.studentjobsearch;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListJobAdapter extends RecyclerView.Adapter<ListJobAdapter.ViewHolder>{

    private ArrayList<Jobs> jobsList;

    public ListJobAdapter(ArrayList<Jobs> jobsList) {
        this.jobsList = jobsList;
    }

    @NonNull
    @Override
    public ListJobAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_jobs_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListJobAdapter.ViewHolder holder, int position) {
        holder.jobTitleTextView.setText(jobsList.get(position).getTitle());
        holder.jobRegionTextView.setText(jobsList.get(position).getRegion());
        holder.jobCategoryTextView.setText(jobsList.get(position).getCategory());
        holder.jobTypeTextView.setText(jobsList.get(position).getType());
    }


    @Override
    public int getItemCount() {
        return jobsList.size(); //confirms how big the arraylist in ListJobs.class is
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView jobTitleTextView;
        public TextView jobRegionTextView;
        public TextView jobCategoryTextView;
        public TextView jobTypeTextView;

        public ViewHolder(View itemView){
            super(itemView);

            jobTitleTextView = itemView.findViewById(R.id.textView_job_title);
            jobRegionTextView = itemView.findViewById(R.id.textView_region);
            jobCategoryTextView = itemView.findViewById(R.id.textView_category);
            jobTypeTextView = itemView.findViewById(R.id.textView_job_type);
        }
    }


    public void setJobTitle(String jobTitle){
        TextView jobTitleText = mView.findViewById(R.id.textView_job_title);
        jobTitleText.setText(jobTitle);
    }
//    public void setCategory(String jobCategory){
//        TextView category = mView.findViewById(R.id.textView_category);
//        category.setText(jobCategory);
//    }
//    public void setRegion(String jobRegion){
//        TextView region = mView.findViewById(R.id.textView_region);
//        region.setText(jobRegion);
//    }
//    public void setJobType(String jobType){
//        TextView jobTypeText = mView.findViewById(R.id.textView_job_type);
//        jobTypeText.setText(jobType);
//    }



}
