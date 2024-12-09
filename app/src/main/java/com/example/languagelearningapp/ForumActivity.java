package com.example.languagelearningapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends AppCompatActivity {

    private EditText postEditText;
    private Button postButton;
    private ListView postsListView;
    private DatabaseReference databaseReference;
    private List<String> posts;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);


        postEditText = findViewById(R.id.postEditText);
        postButton = findViewById(R.id.postButton);
        postsListView = findViewById(R.id.postsListView);

        databaseReference = FirebaseDatabase.getInstance().getReference("Posts");
        posts = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, posts);
        postsListView.setAdapter(adapter);

        postButton.setOnClickListener(v -> {
            String postText = postEditText.getText().toString().trim();
            if (!postText.isEmpty()) {
                String postId = databaseReference.push().getKey();
                databaseReference.child(postId).setValue(postText);
                postEditText.setText("");
                Toast.makeText(this, "Post added", Toast.LENGTH_SHORT).show();
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                posts.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    String post = postSnapshot.getValue(String.class);
                    posts.add(post);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ForumActivity.this, "Failed to load posts", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
