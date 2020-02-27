// Converting date from "01-01-2019" format to "January 1st"？coding

import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {
    public static void main(String[] args) {
        Date ss = new Date();
        System.out.println("一般日期输出：" + ss);
        System.out.println("时间戳：" + ss.getTime());
        //Date aw = Calendar.getInstance().getTime();//获得时间的另一种方式，测试效果一样
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(ss.getTime());//这个就是把时间戳经过处理得到期望格式的时间
        System.out.println("格式化结果0：" + time);
        
        SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd,yyyy");
        time = format1.format(ss.getTime());
        System.out.println("格式化结果1：" + time);
    }

}
// OUTPUT: 
// 一般日期输出：Thu Feb 27 22:11:17 UTC 2020
// 时间戳：1582841477833
// 格式化结果0：2020-02-27 22:11:17
// 格式化结果1：February 27,2020
