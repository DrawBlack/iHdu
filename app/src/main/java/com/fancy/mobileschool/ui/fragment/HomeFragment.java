package com.fancy.mobileschool.ui.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fancy.mobileschool.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
@SuppressWarnings("all")
public class HomeFragment extends Fragment {

    private View scheduleView;

    private FrameLayout classLayout;

    private DisplayMetrics metrics = new DisplayMetrics();

    private static final int FIRST_BLOCK_WIDTH = 62;

    private static final int FIRST_BLOCK_HEIGHT = 100;

    private int classNumBlockHeight;

    private int weekRowBlockWidth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        scheduleView = inflater.inflate(R.layout.fragment_home, container, false);
        classLayout = (FrameLayout) scheduleView.findViewById(R.id.class_view);
        drawFirstRow();
        drawClassNum();
        drawGridView();
        return scheduleView;
    }


    private void drawFirstRow() {
        LinearLayout firstRowView = (LinearLayout) scheduleView.findViewById(R.id.first_row);
        int widthPixels = metrics.widthPixels;
        for (int i = 0 ; i < 8 ; i++) {
            TextView textView = new BorderTextView(getContext());
            textView.setHeight(FIRST_BLOCK_HEIGHT);
            weekRowBlockWidth = (widthPixels - FIRST_BLOCK_WIDTH) / 7;
            if (i == 0){
                textView.setWidth(FIRST_BLOCK_WIDTH);
                textView.setText("三月 ");
            }
            else{
                textView.setWidth(weekRowBlockWidth);
                textView.setText("星期" + i);
            }

            textView.setGravity(Gravity.CENTER);
            firstRowView.addView(textView);
        }
    }

    private void drawClassNum() {
        LinearLayout classNumView = (LinearLayout) scheduleView.findViewById(R.id.class_num);
        int height = metrics.heightPixels;
        for (int i = 1 ; i <=12 ; i++) {
            TextView textView = new BorderTextView(getContext());
            classNumBlockHeight = (height - 100)/10;
            textView.setHeight(classNumBlockHeight);
            textView.setWidth(FIRST_BLOCK_WIDTH);
            textView.setText(i + "");
            textView.setGravity(Gravity.CENTER);
            classNumView.addView(textView);
        }
    }

    private void drawGridView(){
        FrameLayout fl = new FrameLayout(getActivity());
        FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(weekRowBlockWidth, classNumBlockHeight*3 - 10);
        flp.setMargins(0, classNumBlockHeight*2 + 5, 0, 0);
        fl.setLayoutParams(flp);
        //fl.setBackgroundColor(R.color.tab_color);

        TextView tv = new TextView(getActivity());
        tv.setText("工程经济学@第十二教研楼305");
        tv.setBackgroundColor(R.color.schedule_background);
        tv.setWidth(weekRowBlockWidth*2);
        fl.addView(tv);




        classLayout.addView(fl);
    }


}

@SuppressWarnings("all")
class BorderTextView extends android.support.v7.widget.AppCompatTextView{

    private int sroke_width = 1;

    public BorderTextView(Context context) {
        super(context);
    }

    public BorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        Paint paint = new Paint();
//        //  将边框设为黑色
//        paint.setColor(android.graphics.Color.BLACK);
//        //  画TextView的4个边
//        canvas.drawLine(0, 0, this.getWidth() - sroke_width, 0, paint);
//        canvas.drawLine(0, 0, 0, this.getHeight() - sroke_width, paint);
//        canvas.drawLine(this.getWidth() - sroke_width, 0, this.getWidth() - sroke_width, this.getHeight() - sroke_width, paint);
//        canvas.drawLine(0, this.getHeight() - sroke_width, this.getWidth() - sroke_width, this.getHeight() - sroke_width, paint);
        super.onDraw(canvas);
    }
}
