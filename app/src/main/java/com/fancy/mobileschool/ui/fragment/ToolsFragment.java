package com.fancy.mobileschool.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.fancy.mobileschool.R;
import com.fancy.mobileschool.ui.ChatFriends;


public class ToolsFragment extends Fragment {

    private LinearLayout linearLayout;

    private DisplayMetrics metric = new DisplayMetrics();

    private final int[] iconRes = new int[] {
            R.drawable.tools_news,
            R.drawable.tools_chat,
            R.drawable.tools_class,
            R.drawable.tools_yun,
            R.drawable.tools_attendence,
            R.drawable.tools_files,
            R.drawable.tools_passion,
            R.drawable.tools_contact,
            R.drawable.tools_more,

    };

    private final String[] funcs = new String[] {
            "新闻",
            "聊天",
            "我的课堂",
            "我的云盘",
            "签到",
            "学院资料",
            "我的兴趣",
            "联系我们",
            "敬请期待",
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        linearLayout = (LinearLayout) view.findViewById(R.id.fragment_tools_view);
        initGridlayout();
        return view;
    }

    private void initGridlayout() {
        int marginLeft = (metric.widthPixels - 220*3)/4;
        int viewHeight;
        Log.i("log", metric.heightPixels + " ");
        if (metric.heightPixels > 1280)
            viewHeight = 320;
        else viewHeight = 200;

        int marginTop = (metric.heightPixels - viewHeight*4)/4;

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(220, viewHeight);
        layoutParams.setMargins(marginLeft, marginTop, 0, 0);

        for (int i = 0 ; i < 3 ; i++) {
            LinearLayout child = (LinearLayout) linearLayout.getChildAt(i);
            for (int j = 0 ; j < 3 ; j++) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tools_item, null, false);
                view.setTag(funcs[i*3 + j]);
                ImageView imageView = (ImageView) view.findViewById(R.id.fragment_tools_item_img);
                TextView textView = (TextView) view.findViewById(R.id.fragment_tools_item_func);
                textView.setText(funcs[i*3 + j]);
                imageView.setImageResource(iconRes[i*3 + j]);

                view.setOnClickListener(new ToolsOnclickListener());
                child.addView(view, layoutParams);
            }
        }

    }

   private class ToolsOnclickListener implements View.OnClickListener {

       @Override
       public void onClick(View view) {
           String tag = (String) view.getTag();

           switch (tag){
               case "聊天" : startActivity(ChatFriends.class);  break;
           }
       }

       private void startActivity(Class<?> desActivity) {
           Intent intent = new Intent(getContext(), desActivity);
           ToolsFragment.this.startActivity(intent);
       }
   }
}
