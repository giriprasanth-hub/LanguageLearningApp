package com.example.languagelearningapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class LessonsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> lessons = Arrays.asList(
                "Lesson 1: Basic Greetings",
                "Lesson 2: Numbers",
                "Lesson 3: Days of the Week",
                "Lesson 4: Common Phrases");

        LessonAdapter adapter = new LessonAdapter(lessons);
        recyclerView.setAdapter(adapter);
    }
}
