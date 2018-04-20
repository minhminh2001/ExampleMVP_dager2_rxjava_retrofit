package com.example.minhpq.realmdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minhpq.realmdemo.model.User;
import com.example.minhpq.realmdemo.interfaces.OnItemlick;
import com.example.minhpq.realmdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minhpq on 4/20/2018.
 */

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {
    private List<User> userList = new ArrayList<>();
    private Context mContext;
    private OnItemlick onItemlick;

    public ListUserAdapter(List<User> userList, Context mContext, OnItemlick onItemlick) {
        this.userList = userList;
        this.mContext = mContext;
        this.onItemlick = onItemlick;
    }

    public void notifyList(List<User> userList) {
        userList.addAll(userList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.raw_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.with(mContext).load(userList.get(position).getAvatar_url())
                .into(holder.imgAvatar);
        holder.tvId.setText(String.valueOf(userList.get(position).getId()));
        holder.tvLogin.setText(userList.get(position).getLogin());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvId, tvLogin;

        public ViewHolder(View itemView) {
            super(itemView);
            imgAvatar = (ImageView) itemView.findViewById(R.id.img_avatar);
            tvId = (TextView) itemView.findViewById(R.id.tv_id);
            tvLogin = (TextView) itemView.findViewById(R.id.tv_login);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemlick.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return userList.size() > 0 ? userList.size() : 0;
    }
}
