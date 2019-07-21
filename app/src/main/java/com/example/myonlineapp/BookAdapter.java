package com.example.myonlineapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private static ClickListener clickListener;

     List<Books> flowerList ;
    private Context context;


    public BookAdapter(List<Books> flowerList, Context context) {
        this.flowerList = flowerList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_view, parent, false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final BookAdapter.BookViewHolder holder, int position) {
        holder.name.setText(flowerList.get(position).getName());
        holder.productId.setText(flowerList.get(position).getProductId());
       // holder.image.setImageResource(Integer.parseInt(flowerList.get(position).getPhoto()));
        holder.instructions.setText(flowerList.get(position).getInstructions());
        holder.price.setText( flowerList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return flowerList.size();
    }


    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name,instructions,price;
        private TextView productId;
        private ImageView image;


        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            productId = itemView.findViewById(R.id.product_id);
            image = itemView.findViewById(R.id.image_view1);
            instructions = itemView.findViewById(R.id.instruction);
            price = itemView.findViewById(R.id.price_id);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public  void  setOnItemClickListener (ClickListener clickListener){
        BookAdapter.clickListener = clickListener;
    }

        public interface ClickListener {
        void onItemClick (int position, View v);
        }
}

