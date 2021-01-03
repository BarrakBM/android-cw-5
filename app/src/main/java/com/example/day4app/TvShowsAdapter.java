package com.example.day4app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.security.PublicKey;
import java.util.ArrayList;

class TvShowsAdapter extends RecyclerView.Adapter {

    ArrayList<TvShows> tvArray;
    Context context;
    RelativeLayout rr;

    public TvShowsAdapter(ArrayList<TvShows> tvArray, Context context, RelativeLayout rr) {
        this.tvArray = tvArray;
        this.context = context;
        this.rr = rr;
    }

    //public TvShowsAdapter(ArrayList<TvShows> tvLibrary) {
    //}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // connect it to TvShowslist
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tvshows_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).name.setText(tvArray.get(position).getName()+"");
        ((ViewHolder) holder).img.setImageResource(tvArray.get(position).getImg());
        ((ViewHolder) holder).year.setText(tvArray.get(position).getYear()+"");
        ((ViewHolder) holder).season.setText(tvArray.get(position).getSeasons()+"");
        ((ViewHolder) holder).episod.setText(tvArray.get(position).getEpi()+"");
        ((ViewHolder)holder).view.setOnClickListener(view -> {
            Intent r = new Intent(context,DetailsActivity.class);
            r.putExtra("TvShows",tvArray.get(position));
            context.startActivity(r);
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete?");
                builder.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TvShows ss = tvArray.get(position);
                       tvArray.remove(position);
                       notifyDataSetChanged();
                        Snackbar.make(rr, "you deleted a TvShow :)",Snackbar.LENGTH_LONG ).setAction("Undo :(", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvArray.add(ss);
                                notifyDataSetChanged(); // Rawan is a good TA

                            }
                        }).show(); // rr
                    }


                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(context,"not deleted",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


    }

    @Override
    public int getItemCount() { // عشان ترجع عدد العناصر بلستة المسلسلات
        return tvArray.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
       //هني تعريف العناصر
        public ImageView img;
        public TextView name;
        public TextView year;
        public TextView season;
        public TextView episod;
        public View view;// مهمه
        public ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // ربط العناصر الي فوق
            view = itemView;  // مهمه عشان يبينون العناصر لان هذا ادابتر مو اكتفتي
            img = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.moviename);
            year = itemView.findViewById(R.id.movieyear);
            season = itemView.findViewById(R.id.movieseason);
            episod = itemView.findViewById(R.id.movieepi);
            delete = itemView.findViewById(R.id.imageView2);


        }
    }
}
