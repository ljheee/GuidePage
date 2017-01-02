package com.ljheee.guidepage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/*
 * 引导页的activity
 */
public class GuidePage extends Activity implements OnPageChangeListener{
    private ViewPager vp;
    private VpageAdapter vad;//引导页图片适配器
    private List<View> views;
    private ImageView[] points;
    private int[] ps={R.id.point1,R.id.point2};//定义引导页上的两个点
    private Button intobutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**全屏设置，隐藏窗口所有装饰**/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guidepage);
        init();
        initPoints();
    }
    private void init() {
        LayoutInflater inflate=LayoutInflater.from(GuidePage.this);
        views=new ArrayList<View>();
        views.add(inflate.inflate(R.layout.guide_first, null));
        views.add(inflate.inflate(R.layout.guide_second, null));
        vad=new VpageAdapter(views, this);
        vp=(ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vad);
        vp.setOnPageChangeListener(this);
        intobutton=(Button) views.get(1).findViewById(R.id.into);
        //设置进入button的点击事件进入到主程序中
        intobutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GuidePage.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    private void initPoints(){
        points=new ImageView[(views.size())];
        for(int i=0;i<views.size();i++){
            points[i]=(ImageView)findViewById(ps[i]);
        }

    }
    @Override
    public void onPageScrollStateChanged(int arg0) {

    }
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }
    //当该页被选择后设置点的图片为白色
    @Override
    public void onPageSelected(int arg0) {

        for(int i=0;i<ps.length;i++){
            if(arg0==i){
                points[i].setImageResource(R.drawable.login_point_selected);
            }else{
                points[i].setImageResource(R.drawable.login_point);
            }
        }
    }
}