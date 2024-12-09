package com.example.languagelearningapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class AchievementsActivity extends AppCompatActivity {

    private TextView achievementsText;
    private List<String> achievements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        achievementsText = findViewById(R.id.achievementsText);

        achievements = new ArrayList<>();
        achievements.add("Completed 10 Lessons!");
        achievements.add("Mastered Beginner Level!");
        achievements.add("Logged in 7 Days in a Row!");

        displayAchievements();
    }

    private void displayAchievements() {
        StringBuilder achievementText = new StringBuilder();
        for (String achievement : achievements) {
            achievementText.append("• ").append(achievement).append("\n");
        }
        achievementsText.setText(achievementText.toString());
    }
}
