package com.example.languagelearningapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class ProgressActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        LineChart chart = findViewById(R.id.progressChart);

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 50));
        entries.add(new Entry(2, 70));
        entries.add(new Entry(3, 85));

        LineDataSet dataSet = new LineDataSet(entries, "Learning Progress");
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        Description description = new Description();
        description.setText("Progress Over Time");
        chart.setDescription(description);
        chart.invalidate(); // refresh
    }
}
