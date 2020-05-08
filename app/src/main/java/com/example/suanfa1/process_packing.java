package com.example.suanfa1;
import java.util.ArrayList;
import java.util.List;

public class process_packing {
    protected float n;
    protected float a, b, d,yingy,a_o,b_o;
    private float ia, ib, ka, kb, ha, hb, n1, n2;
    private float ja, jb;
    protected  float yingyux,yingyuy;//盈余后-原来的差额
    protected boolean f1, f2,flagsame=false;
    public List<Float> xx = new ArrayList();
    public List<Float> yy = new ArrayList();
    public List<Float> xx_o = new ArrayList();
    public List<Float> yy_o = new ArrayList();


    public process_packing(float i, float j, float k, float m) {
        this.a_o=i;
        this.b_o=j;
        this.d=k;
        this.yingy=m;
    }

    public float zhijing(){
        float k=d/2;
        return d;
    }


    public void setnum(float i, float j) {
        a = i;
        b = j;
        ia = (float) Math.floor(a/d);
        ib = (float)Math.floor(b/d);
        ja = (a%d);
        jb = (b%d);
        ha = (float) Math.floor((b / d - 1) * 2 / Math.sqrt(3) + 1);//计算堆积层数
        hb = (float) Math.floor((a / d - 1) * 2 / Math.sqrt(3) + 1);


    }

    /**
     * 先计算排列的算法能产生的摆放的最大个数，进行比较选择最优的一种算法进行画圆排列（n最大）
     *
     */
    public float count() {
        //若以a边为底边往上堆积
        float ntemp=0;
        float flag = d, flag0 = 0, j, k;
        ka = -1;
        for (int i = 0; i <= ha; i++) {
            j = ha - i;
            flag0 = (float) (b - d * (j + i * Math.sqrt(3) / 2));
            if (flag0 >= 0 && flag0 < flag) {
                flag = flag0;
                ka = i;
            }//获取密集排布最大行数
        }//计算正常排列和密集排列（正三角排列）数

        if (ka < 0) {
            ha = ha - 1;
        }
        if (ja < d / 2) {
            n1 = (float) (ia * ha - Math.floor((ka + 1) / 2));
            f1 = false;//密集+正常
        } else {
            n1 = ia * ha;
            f1 = true;//全正常
        }
        //若以b边为底边往上堆积

        float flags = d;
        kb = -1;
        for (int i = 0; i <= hb; i++) {
            k = hb - i;
            float flags0 = (float) (a - d * (k + i * Math.sqrt(3) / 2));
            if (flags0 >= 0 && flags0 < flags) {
                flags = flags0;
                kb = i;
            }
        }
        if (kb < 0) {
            hb = hb - 1;
        }
        if (jb < d / 2) {
            n2 = (float) (ib * hb - Math.floor((kb + 1) / 2));
            f2 = false;
        } else {
            n2 =  ib * hb;
            f2 = true;
        }
        return ntemp = (int) ((n1 < n2) ? n2 : n1);


    }

    public void case1(float p, float d, float k, float h) {
        float z = k;
        if(a==a_o&&b==b_o&&flagsame==false) {
            if (k < 0) {
                z = z + 1;
            }
            for (int m = 0; m <= h - z - 1; m++) {
                for (int l = 0; l <= p - 1; l++) {
                    xx_o.add((float) (d / 2 + l * d));
                    yy_o.add((float) (d / 2 + m * d));
                }
            }
            if (k > 0) {
                for (int m = 0; m <= k - 1; m++) {
                    if (((m + 1) % 2) == 1) {
                        for (int l = 0; l <= p - 2; l++) {
                            xx_o.add((float) (l + 1) * d);
                            yy_o.add((float) ((h - k - 0.5) * d + (Math.sqrt(3) / 2) * (m + 1) * d));
                        }
                    } else {
                        for (int l = 0; l <= p - 1; l++) {
                            xx_o.add((float) (d / 2 + l * d));
                            yy_o.add((float) ((h - k - 0.5) * d + (Math.sqrt(3) / 2) * (m + 1) * d));
                        }
                    }
                }
            }
        }
        else
        {
            if (k < 0) { z = z + 1; }
            for (int m = 0; m <= h - z - 1; m++) {
                for (int l = 0; l <= p - 1; l++) {
                    xx.add((float) (d / 2 + l * d));
                    yy.add((float) (d / 2 + m * d));
                }
            }
            if (k > 0) {
                for (int m = 0; m <= k - 1; m++) {
                    if (((m + 1) % 2) == 1) {
                        for (int l = 0; l <= p - 2; l++) {
                            xx.add((float) (l + 1) * d);
                            yy.add((float) ((h - k - 0.5) * d + (Math.sqrt(3) / 2) * (m + 1) * d));
                        }
                    } else {
                        for (int l = 0; l <= p - 1; l++) {
                            xx.add((float) (d / 2 + l * d));
                            yy.add((float) ((h - k - 0.5) * d + (Math.sqrt(3) / 2) * (m + 1) * d));
                        }
                    }
                }
            }

        }
    }

    public void case2(float p,float d,float k,float h) {
        float z = k;
        if (a == a_o && b == b_o && flagsame == false) {
            if (a == a_o && b == b_o) {
                if (k < 0) {
                    z = z + 1;
                }
                for (int m = 0; m <= h - z - 1; m++) {
                    for (int l = 0; l <= p - 1; l++) {
                        xx_o.add((float) (d / 2 + l * d));
                        yy_o.add((float) (d / 2 + m * d));
                    }
                }
                if (k > 0) {
                    for (int m = 0; m <= k - 1; m++) {
                        if (((m + 1) % 2) == 1) {
                            for (int l = 0; l <= p - 1; l++) {
                                xx_o.add((float) (l + 1) * d);
                                yy_o.add((float) ((h - k - 0.5) * d + (Math.sqrt(3) / 2) * (m + 1) * d));
                            }
                        } else {
                            for (int l = 0; l <= p - 1; l++) {
                                xx_o.add((float) (d / 2 + l * d));
                                yy_o.add((float) ((h - k - 0.5) * d + (Math.sqrt(3) / 2) * (m + 1) * d));
                            }
                        }
                    }
                }
            }
        } else {
            if (k < 0) {
                z = z + 1;
            }
            for (int m = 0; m <= h - z - 1; m++) {
                for (int l = 0; l <= p - 1; l++) {
                    xx.add((float) (d / 2 + l * d));
                    yy.add((float) (d / 2 + m * d));
                }
            }
            if (k > 0) {
                for (int m = 0; m <= k - 1; m++) {
                    if (((m + 1) % 2) == 1) {
                        for (int l = 0; l <= p - 1; l++) {
                            xx.add((float) (l + 1) * d);
                            yy.add((float) ((h - k - 0.5) * d + (Math.sqrt(3) / 2) * (m + 1) * d));
                        }
                    } else {
                        for (int l = 0; l <= p - 1; l++) {
                            xx.add((float) (d / 2 + l * d));
                            yy.add((float) ((h - k - 0.5) * d + (Math.sqrt(3) / 2) * (m + 1) * d));
                        }
                    }
                }
            }
        }
    }



    public void fillin() {
        if (count() == n1) {
            if (f1 == false) {
                case1(ia, d, ka, ha);
            }
            if (f1 == true) {
                case2(ia, d, ka, ha);
            }
        } else {
            if (f2 == false) {
                case1(ib, d, kb, hb);
            }
            if (f2 == true) {
                case2(ib, d, kb, hb);
            }
        }
    }
    public void testnum(){
        float h=a_o,j=b_o+yingy,flag_n=0,afin=0,bfin = 0,count_o;
        setnum(a_o,b_o);
        count_o=count();
        fillin();
        for(int i=0;i<=yingy;i++)
        {
            if(i==0){
                setnum(h,j);
                flag_n=count();
                afin = h;
                bfin = j;
            }
            else {
                h += 1;
                j -= 1;
                setnum(h, j);
                if (count() > flag_n)
                {
                    flag_n = count();
                    afin = h;
                    bfin = j;

                }
            }
        }

        yingyux=afin-a_o;
        yingyuy=bfin-b_o;
        if(yingy==0)
        {flagsame=true;}
        if(count_o<=flag_n)
        {setnum(afin,bfin);
            n=flag_n;
            count();}
        else {
            flagsame=true;
            setnum(a_o,b_o);
            n=flag_n;
            count();
        }
    }
    public void dofunc(){
        testnum();
        count();
        fillin();
    }

}
