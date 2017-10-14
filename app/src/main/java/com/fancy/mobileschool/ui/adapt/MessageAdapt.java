package com.fancy.mobileschool.ui.adapt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fancy.mobileschool.R;
import com.fancy.mobileschool.ui.MessageDetailActivity;

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
                R.layout.fragment_message_item, parent, false), context);

        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        if (position%2 == 0){
            holder.getIcon().setImageResource(R.drawable.time);
        }else
            holder.getIcon().setImageResource(R.drawable.icon);

        holder.getMessage().setText("这是一条信息");
    }

    @Override
    public int getItemCount() {
        return 15;
    }


}


class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ImageView icon;

    private TextView message;

    private TextView timeText;

    private Context context;

    public MessageViewHolder(View itemView, Context context){
        super(itemView);
        this.context = context;
        icon = (ImageView) itemView.findViewById(R.id.message_item_img);
        message = (TextView) itemView.findViewById(R.id.message_text);
        timeText = (TextView) itemView.findViewById(R.id.message_item_time_text);
        setOnclick(itemView);
    }


    public ImageView getIcon() {
        return icon;
    }

    public TextView getMessage() {
        return message;
    }

    public TextView getTimeText() {
        return timeText;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public void setMessage(TextView message) {
        this.message = message;
    }

    public void setTimeText(TextView timeText) {
        this.timeText = timeText;
    }

    private void setOnclick(View view){
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.message_item){
            Intent intent = new Intent(context, MessageDetailActivity.class);
            intent.putExtra("message", message.getText());
            System.out.println(message.getText());
            context.startActivity(intent);
        }
    }
}