package com.fancy.mobileschool.ui;

import com.fancy.mobileschool.R;
import com.fancy.mobileschool.ui.fragment.HomeFragment;
import com.fancy.mobileschool.ui.fragment.MessageFragment;
import com.fancy.mobileschool.ui.fragment.MyFragment;
import com.fancy.mobileschool.ui.fragment.ToolsFragment;

/**
 * Created by Jackie on 2017/9/26.
 *
 */

public class Tabs {

    public static String[] texts = new String[]{
            "主页", "工具", "通知", "个人",
    };

    public static int[] imgRes = new int[] {
            R.drawable.home,
            R.drawable.tools,
            R.drawable.message,
            R.drawable.mine,
    };

    public static String[] tabID = texts;

    public static int length = texts.length;

    public static Class[] fragments = new Class[]{
            HomeFragment.class,
            ToolsFragment.class,
            MessageFragment.class,
            MyFragment.class,
    };
}
