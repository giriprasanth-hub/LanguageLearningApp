package com.example.languagelearningapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup optionGroup;
    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        optionGroup = findViewById(R.id.optionGroup);

        questionList = new ArrayList<>();
        questionList.add(new Question("What is 'Hello' in Spanish?", Arrays.asList("Hola", "Bonjour", "Ciao", "Hello"), 0));
        questionList.add(new Question("What is 'Thank you' in French?", Arrays.asList("Merci", "Gracias", "Danke", "Grazie"), 0));
        questionList.add(new Question("What is 'Goodbye' in Italian?", Arrays.asList("Ciao", "Adios", "Au revoir", "Bye"), 0));

        loadQuestion();

        findViewById(R.id.submitAnswerButton).setOnClickListener(v -> checkAnswer());
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);
            questionText.setText(currentQuestion.getText());
            ((RadioButton) optionGroup.getChildAt(0)).setText(currentQuestion.getOptions().get(0));
            ((RadioButton) optionGroup.getChildAt(1)).setText(currentQuestion.getOptions().get(1));
            ((RadioButton) optionGroup.getChildAt(2)).setText(currentQuestion.getOptions().get(2));
            ((RadioButton) optionGroup.getChildAt(3)).setText(currentQuestion.getOptions().get(3));
        } else {
            Toast.makeText(this, "Quiz Completed! Your Score: " + score, Toast.LENGTH_LONG).show();
        }
    }

    private void checkAnswer() {
        int selectedOptionIndex = optionGroup.indexOfChild(findViewById(optionGroup.getCheckedRadioButtonId()));
        if (selectedOptionIndex == questionList.get(currentQuestionIndex).getCorrectOptionIndex()) {
            score++;
        }
        currentQuestionIndex++;
        optionGroup.clearCheck();
        loadQuestion();
    }
}
