package com.hieropanda.dicodingsubmission;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String d1[], d2[];
    int image[];
    Context context;

    public MyAdapter(Context ct, String c1[], String c2[], int img[]){
        context = ct;
        d1 = c1;
        d2 = c2;
        image = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myTxt1.setText(d1[position]);
        holder.myTxt2.setText(d2[position]);
        holder.myImage.setImageResource(image[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DescActivity.class);
                intent.putExtra("d1", d1[position]);
                intent.putExtra("d2", d2[position]);
                intent.putExtra("myImg", image[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myTxt1, myTxt2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myTxt1 = itemView.findViewById(R.id.myTxt1);
            myTxt2 = itemView.findViewById(R.id.myTxt2);
            myImage = itemView.findViewById(R.id.ImgView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
