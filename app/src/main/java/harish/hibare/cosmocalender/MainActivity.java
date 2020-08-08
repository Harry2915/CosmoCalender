package harish.hibare.cosmocalender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.OrientationHelper;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.applikeysolutions.cosmocalendar.settings.lists.connected_days.ConnectedDays;
import com.applikeysolutions.cosmocalendar.view.CalendarView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView1;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date[] arrayOfDates;
    Set<Long> days = new TreeSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
        textView1=findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TraditionalWay.class));
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.activity_traditional_way);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(false);
                ImageView  imageView=dialog.findViewById(R.id.imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                CalendarView calendarView = dialog.findViewById(R.id.calendar_view);
                calendarView.setCalendarOrientation(OrientationHelper.HORIZONTAL);
                String a[] = {"2020-07-18","2020-04-01","2020-06-28","2020-04-08","2020-08-28" ,"2020-08-10"};
                try {
                    for (int u=0;u<a.length;u++) {
                        arrayOfDates = new Date[]{fromStringToDate(a[u])};
                        System.out.println(arrayOfDates);
                        for(int b=0;b<arrayOfDates.length;b++)
                        {
                            days.add(arrayOfDates[b].getTime());
                            System.out.println(arrayOfDates[b].getTime());
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //Define colors

                int selectedTextColor = Color.parseColor("#ff4087");
                int textColor = Color.parseColor("#ff6500");
                ConnectedDays connectedDays = new ConnectedDays(days, textColor,selectedTextColor);
                calendarView.addConnectedDays(connectedDays);
                System.out.println("Test : " + days);
                calendarView.setConnectedDayIconRes(R.drawable.present);
                dialog.show();
                Window window=dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
            }
        });
    }

    private Date fromStringToDate(String s) throws ParseException {
        return dateFormat.parse(s);
    }
}