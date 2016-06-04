package com.jaydot2.fitnessapp.basic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jamesbray on 6/3/16.
 */
public class FitnessItemAdapter extends RecyclerView.Adapter<FitnessItemAdapter.ViewHolder> {

    static final int TYPE_HEADER = 0;
    static final int TYPE_ITEM = 1;

    private String[] mNavTitles;
    private int[] mIcons;

    private String username;
    private int profile;
    private String email;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        int holderId;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView username;
        TextView email;

        public ViewHolder(View itemView, int ViewType) {

            super(itemView);

            if(ViewType == TYPE_ITEM) {
                textView = (TextView)itemView.findViewById(R.id.rowText);
                imageView = (ImageView)itemView.findViewById(R.id.rowIcon) ;
                holderId = 1;
            } else {
                username = (TextView)itemView.findViewById(R.id.username);
                email = (TextView)itemView.findViewById(R.id.email);
                profile = (ImageView)itemView.findViewById(R.id.circleView);
                holderId = 0;
            }
        }

    }

    public FitnessItemAdapter(String[] titles, String name, String email) {

        mNavTitles = titles;
        this.username = name;
        this.email = email;

    }

    /**
     * <p>
     * Get the layout for the header or the list item
     * </p>
     * @param parent
     * @param viewType
     * @return
     */
    public FitnessItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
            ViewHolder vhItem = new ViewHolder(v, viewType);
            return vhItem;
        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            ViewHolder vhHeader = new ViewHolder(v, viewType);
            return vhHeader;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(FitnessItemAdapter.ViewHolder holder, int position) {
        if(holder.holderId == 1) {
            holder.textView.setText(mNavTitles[position - 1]);
        } else {
            holder.profile.setImageResource(profile);
            holder.username.setText(username);
            holder.email.setText(email);
        }
    }


    @Override
    public int getItemCount() {
        return mNavTitles.length + 1;
    }


    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}
