package com.example.retrofitrecycler;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private ArrayList<CourseModel> courseModalArrayList;
    private Context context;


    public CourseAdapter(ArrayList<CourseModel> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }


    public void filterList(ArrayList<CourseModel>filterllist) {

        courseModalArrayList = filterllist;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {

        CourseModel modal = courseModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getCourseName());
        holder.courseDescTV.setText(modal.getCourseDescription());
        //ks
    }

    @Override
    public int getItemCount() {

        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView courseNameTV, courseDescTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
        }
    }
}
