package com.example.materialcalendar_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.materialcalendar_ex2.databinding.ActivityMainBinding;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private MaterialCalendarView calendar;
    public Context context;
    private ArrayList<CalendarDay> calendarDayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //바인딩
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        calendar = binding.calendarView;
        MainActivity activity = this;
        View view = binding.getRoot();

        //색칠할 날짜를 calendarDayList에 추가
        calendarDayList.add(CalendarDay.from(2024, 1, 25));
        calendarDayList.add(CalendarDay.from(2024, 05, 24));
        calendarDayList.add(CalendarDay.from(2022, 05, 23));

        // 오늘날짜 선택
        calendar.setSelectedDate(CalendarDay.today());
        // 데코레이터
        Decorator decorator = new Decorator(calendarDayList, activity);
        binding.calendarView.addDecorator(decorator);
    }
}