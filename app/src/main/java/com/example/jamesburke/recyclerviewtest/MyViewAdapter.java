package com.example.jamesburke.recyclerviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jamesburke on 6/22/18.
 */

public class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.NumberViewHolder> {

    private static final String LOG_TAG = MyViewAdapter.class.getSimpleName();

    private int mNumberItems;
    private static int viewHolderCount;

    //Constructor
    public MyViewAdapter(int numberOfItems){

        mNumberItems = numberOfItems;
        viewHolderCount = 0;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View myView = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(myView);

        int backgroundColorForInstance = ColorUtils.getViewHolderBackgroundColor(context, viewHolderCount);

        viewHolder.itemView.setBackgroundColor(backgroundColorForInstance);

        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        Log.d(LOG_TAG, "#" + position);
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView listItemNumberView;

        public NumberViewHolder(View view)
        {
            super(view);
            listItemNumberView = (TextView) view.findViewById(R.id.tv_item_number);
        }

        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
