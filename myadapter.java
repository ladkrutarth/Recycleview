package com.example.recycleview_javaclass;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<datamodel> dataholder;
    Context context;
    public myadapter(ArrayList<datamodel> dataholder,Context context) {
        this.dataholder = dataholder;
        this.context = context;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);
        return new myviewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull  myviewholder holder, int position)
    {
         final datamodel temp = dataholder.get(position);
        holder.img.setImageResource(dataholder.get(position).getImage());
        holder.header.setText(dataholder.get(position).getHeader());
        holder.desc.setText(dataholder.get(position).getDesc());

           holder.img.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent;
                   intent = new Intent(context,MainActivity2.class);
                   intent.putExtra("image",temp.getImage());
                   intent.putExtra("header",temp.getHeader());
                   intent.putExtra("desc",temp.getDesc());
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);

               }
           });

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView header,desc;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=itemView.findViewById(R.id.img1);
            header=itemView.findViewById(R.id.t1);
            desc=itemView.findViewById(R.id.t2);
        }
    }
}