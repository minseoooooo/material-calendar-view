package com.example.materialcalendar_ex2;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

public class Decorator implements DayViewDecorator {

    private Drawable drawable;
    private int color;
    private HashSet<CalendarDay> dates;
    private TextView textView;

    public Decorator(Collection<CalendarDay> dates, Activity context) {
        drawable = context.getDrawable(R.drawable.calendar_background_notempty);

        this.dates = new HashSet<>(dates);
    }

    public void TodayDecorator(Collection<CalendarDay> dates, Activity context) {
        drawable = context.getDrawable(R.drawable.calendar_background_today);

        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
    }

}