package com.example.suanfa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btkey1;
    EditText chang,kuan, zhijing,yingyu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btkey1 =  findViewById(R.id.kaishi);

        chang=findViewById(R.id.shuruc);
        kuan=findViewById(R.id.shuruk);
        zhijing=findViewById(R.id.shurubj);
        yingyu=findViewById(R.id.shuruyy);
        KEEP_one_decimal(chang);
        KEEP_one_decimal(kuan);
        KEEP_one_decimal(zhijing);
        KEEP_one_decimal(yingyu);
        btkey1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,huatu.class);
                Bundle b=new Bundle();
                String c=chang.getText().toString();
                String k=kuan.getText().toString();
                String zj=zhijing.getText().toString();
                String yy=yingyu.getText().toString();
                b.putString("chang",c);
                b.putString("kuan",k);
                b.putString("zhijing",zj);
                b.putString("yingyu",yy);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }











    public void KEEP_one_decimal(EditText t){ t.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
       //设置字符过滤小数点1位
       t.setFilters(new InputFilter[]{new InputFilter() {
           @Override

           public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
               if (source.equals(".") && dest.toString().length() == 0) {
                   return "0.";
               }
               if (dest.toString().contains(".")) {
                   int index = dest.toString().indexOf(".");
                   int length = dest.toString().substring(index).length();
                   if (length == 2) {
                       return "";
                   }
               }
               return null;
           }
       }});}



}





