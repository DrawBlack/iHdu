package com.fancy.mobileschool.ui.adapt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fancy.mobileschool.R;

/**
 * Created by Jackie on 2017/10/3.
 * self adapt for RecyclerView
 */

public class MessageAdapt extends RecyclerView.Adapter<MessageViewHolder> {

    private Context context;

    public MessageAdapt(Context context){
        this.context = context;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MessageViewHolder messageViewHolder = new MessageViewHolder(LayoutInflater.from(context).inflate(
                R.layout.fragment_message_item, parent, false));

        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        if (position%2 == 1){
            holder.getIcon().setImageResource(R.drawable.time);
        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }

}


class MessageViewHolder extends RecyclerView.ViewHolder{

    private ImageView icon;

    private TextView message;

    public MessageViewHolder(View itemView){
        super(itemView);
        icon = (ImageView) itemView.findViewById(R.id.message_item_img);
        message = (TextView) itemView.findViewById(R.id.message_text);
    }


    public ImageView getIcon() {
        return icon;
    }

    public TextView getMessage() {
        return message;
    }
}