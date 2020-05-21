package tn.moez.multitp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder>{
    private Context context;
    Activity activity;
    private ArrayList book_id, book_title, book_author, book_pages;
    Animation translate_anim ;

    CustomAdapter2(Activity activity,
                  Context context,
                  ArrayList book_id,
                  ArrayList book_title,
                  ArrayList book_author,
                  ArrayList book_pages){
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_author = book_author;
        this.book_title = book_title;
        this.book_pages = book_pages;
    }

    @NonNull
    @Override
    public CustomAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_rows,parent, false);
        return new CustomAdapter2.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter2.MyViewHolder holder, int position) {
        holder.book_id_txt.setText(String.valueOf(book_pages.get(position)));
        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        //holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));


    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt;
        LinearLayout mainLayout1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            book_pages_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout1 = itemView.findViewById(R.id.mainLayout1);
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout1.setAnimation(translate_anim);
        }
    }
}
