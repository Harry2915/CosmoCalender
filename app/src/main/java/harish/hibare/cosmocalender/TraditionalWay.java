package harish.hibare.cosmocalender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.OrientationHelper;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import com.applikeysolutions.cosmocalendar.view.CalendarView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class TraditionalWay extends AppCompatActivity {
CalendarView calendarView;
Calendar calendar=Calendar.getInstance();
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
Date[] arrayofDates;
Set<Long> days=new TreeSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_way);
        calendarView=findViewById(R.id.calendar_view);
        calendarView.setCalendarOrientation(OrientationHelper.HORIZONTAL);

        String a[] = {"2020-07-18","2020-04-01","2020-06-28","2020-04-08","2020-08-28" ,"2020-08-10"};
        try {
            for(int u=0;u<a.length;u++){
                arrayofDates=new Date[]{
                        fromStringToDate(a[u])
                };
                System.out.println(arrayofDates);
                for(int b=0;b<arrayofDates.length;b++){
                    days.add(arrayofDates[b].getTime());
                    System.out.println(arrayofDates[b].getTime());
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private Date fromStringToDate(String s) throws ParseException {
        return dateFormat.parse(s);
    }
}