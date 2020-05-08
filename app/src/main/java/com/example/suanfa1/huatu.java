package com.example.suanfa1;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class huatu extends AppCompatActivity {
TextView nc,nk,nzj,ny;
private float cc,kk,zzj,nyy;
public int screenHeight,screenWidth,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huatu);
        getAndroiodScreenProperty();
        Intent it = getIntent();
        Bundle b = it.getExtras();
        String c=b.getString("chang"),k=b.getString("kuan"),zj=b.getString("zhijing"),yingyu=b.getString("yingyu");
        nc=findViewById(R.id.sc);
        nk=findViewById(R.id.sk);
        nzj=findViewById(R.id.szj);


        final View v=findViewById(R.id.hua);
        cc=Float.parseFloat(c);
        kk=Float.parseFloat(k);
        zzj=Float.parseFloat(zj);
        nyy=Float.parseFloat(yingyu);
        final huahua h=new huahua(huatu.this);
        process_packing nt=new process_packing(cc,kk,zzj,nyy);
        nt.testnum();
        TextView tx=findViewById(R.id.num);
        int kkk=(int)nt.n;
        tx.setText(Integer.toString(kkk));

        nc.setText(Float.toString(nt.a_o));nk.setText(Float.toString(nt.b_o));nzj.setText(zj);
        h.findViewById(R.id.hua);
       int bb=dip2px(huatu.this,100);
        h.setwide(screenWidth,cc,kk,zzj,nyy);











    }
    public void getAndroiodScreenProperty() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        this.screenWidth = (int) (width / density);  // 屏幕宽度(dp)
        this.screenHeight = (int) (height / density);// 屏幕高度(dp)
    }
    private int dip2px(Context context, float dipValue) {
        Resources r= context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
    }


    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            Intent mm=new Intent(huatu.this,MainActivity.class);
            startActivity(mm);
            finish();
            return false;
        }
        return false;

    }

}