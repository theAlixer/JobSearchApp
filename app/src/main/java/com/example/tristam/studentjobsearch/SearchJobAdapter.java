package com.example.tristam.studentjobsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchJobAdapter extends RecyclerView.Adapter<SearchJobAdapter.SearchViewHolder>{
    Context context;
    ArrayList<Jobs> jobArrayList;

    class SearchViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView region;
        TextView category;
        TextView type;


        public SearchViewHolder(View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtTitle);
            region = (TextView) itemView.findViewById(R.id.txtRegion);
            category = (TextView) itemView.findViewById(R.id.txtCategory);
            type = (TextView) itemView.findViewById(R.id.txtJobType);
        }
    }

    public SearchJobAdapter(Context context, ArrayList<Jobs> jobArrayList) {
        this.context = context;
        this.jobArrayList = jobArrayList;
    }

    @Override
    public SearchJobAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_search_result_item, parent, false);
        return new SearchJobAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.title.setText(jobArrayList.get(position).getTitle());
        holder.region.setText(jobArrayList.get(position).getRegion());
        holder.category.setText(jobArrayList.get(position).getCategory());
        holder.type.setText(jobArrayList.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
