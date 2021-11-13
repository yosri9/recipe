package com.example.recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.WordViewHolder>  {
    private final LinkedList<String> title;
    private final LinkedList<String> description;

    private LayoutInflater mInflater;

    public RecipeListAdapter(Context context,
                             LinkedList<String> title, LinkedList<String> description) {
        mInflater = LayoutInflater.from(context);
        this.title = title;
        this.description = description;
    }



    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrentTitle = title.get(position);
        String mCurrentDescription = description.get(position);
        holder.title.setText(mCurrentDescription);

        holder.description.setText(mCurrentTitle);
    }

    @Override
    public int getItemCount() {
        return title.size();
    }
    static class WordViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;

        final RecipeListAdapter mAdapter;


        public WordViewHolder(@NonNull View itemView, RecipeListAdapter adapter) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

            this.mAdapter = adapter;
        }
    }

}
