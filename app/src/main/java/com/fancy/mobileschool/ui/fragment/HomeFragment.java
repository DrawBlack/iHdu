package com.fancy.mobileschool.ui.fragment;

import android.content.Context;
import android.graphics.Canvas;
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
import com.fancy.mobileschool.entity.StudentClass;
import com.fancy.mobileschool.ui.widget.ClassDialog;

import java.util.ArrayList;
import java.util.List;

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

    private static final int FIRST_BLOCK_HEIGHT = 120;

    private int classNumBlockHeight;

    private int weekRowBlockWidth;

    private int[] tvRes = new int[] {
            R.drawable.corners_tv1,
            R.drawable.corners_tv4,
            R.drawable.corners_tv2,
            R.drawable.corners_tv3,
            R.drawable.corners_tv5,
            R.drawable.corners_tv6
    };

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
            classNumBlockHeight = (height - 100)/13;
            textView.setHeight(classNumBlockHeight);
            textView.setWidth(FIRST_BLOCK_WIDTH);
            textView.setText(i + "");
            textView.setGravity(Gravity.CENTER);
            classNumView.addView(textView);
        }
    }

    private void drawGridView(){

        List<StudentClass> classes = new ArrayList<>();
        classes.add(new StudentClass(1, 3, 3, "工程经济学"));
        classes.add(new StudentClass(4, 6, 4, "软件过程与管理"));
        classes.add(new StudentClass(1, 6, 4, "软件需求分析"));
        classes.add(new StudentClass(3, 1, 2, "软件设计与体系架构"));
        classes.add(new StudentClass(3, 6, 2, "形式与政策"));
        classes.add(new StudentClass(1, 10, 2, "计算机网络实验"));
        classes.add(new StudentClass(2, 6, 4, "安卓移动开发"));

        int count = classes.size();
        for (int i = 0; i < count; i++) {

            StudentClass studentClass = classes.get(i);
            FrameLayout fl = new FrameLayout(getActivity());
            FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(weekRowBlockWidth - 10 , classNumBlockHeight*studentClass.getClassNum() - 10);
            flp.setMargins( (studentClass.getDay() - 1)*weekRowBlockWidth + 5 , classNumBlockHeight*(studentClass.getStartClassNum() - 1) + 5, 0, 0);
            fl.setLayoutParams(flp);

            TextView tv = new TextView(getActivity());
            tv.setText(studentClass.getClassName());
            tv.setBackgroundResource(tvRes[i%6]);
            tv.setWidth(weekRowBlockWidth);
            fl.addView(tv);

            setItemViewOnClickLisener(fl, (String) tv.getText());

            classLayout.addView(fl);
        }

    }

    private void setItemViewOnClickLisener(View view, final String classInfo) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassDialog dialog = new ClassDialog(getActivity(), classInfo);
                dialog.show();
            }
        });
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
