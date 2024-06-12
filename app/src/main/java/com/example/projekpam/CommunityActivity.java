package com.example.projekpam;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommunityActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPosts;
    private Button buttonAddPost;
    private DatabaseReference mDatabase;
    private ArrayList<Post> postList;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        recyclerViewPosts = findViewById(R.id.recyclerViewPosts);
        buttonAddPost = findViewById(R.id.buttonAddPost);
        mDatabase = FirebaseDatabase.getInstance().getReference("Posts");

        postList = new ArrayList<>();
        postAdapter = new PostAdapter(postList, this);

        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPosts.setAdapter(postAdapter);

        buttonAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPostDialog(null, -1);
            }
        });

        loadPosts();
    }

    private void loadPosts() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Post post = snapshot.getValue(Post.class);
                    postList.add(post);
                }
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CommunityActivity.this, "Gagal mengambil data post", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showPostDialog(final Post post, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_post, null);
        builder.setView(dialogView);

        final EditText editTextTitle = dialogView.findViewById(R.id.editTextTitle);
        final EditText editTextContent = dialogView.findViewById(R.id.editTextContent);

        if (post != null) {
            editTextTitle.setText(post.getTitle());
            editTextContent.setText(post.getContent());
        }

        builder.setTitle(post == null ? "Tambah Post Baru" : "Edit Post");
        builder.setPositiveButton(post == null ? "Tambah" : "Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = editTextTitle.getText().toString().trim();
                String content = editTextContent.getText().toString().trim();

                if (title.isEmpty() || content.isEmpty()) {
                    Toast.makeText(CommunityActivity.this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (post == null) {
                    String id = mDatabase.push().getKey();
                    Post newPost = new Post(id, title, content);
                    mDatabase.child(id).setValue(newPost);
                } else {
                    post.setTitle(title);
                    post.setContent(content);
                    mDatabase.child(post.getId()).setValue(post);
                }
            }
        });

        builder.setNegativeButton("Batal", null);
        builder.create().show();
    }

    public void editPost(Post post, int position) {
        showPostDialog(post, position);
    }

    public void deletePost(final Post post, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Konfirmasi");
        builder.setMessage("Anda yakin ingin menghapus post ini?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDatabase.child(post.getId()).removeValue();
                postList.remove(position);
                postAdapter.notifyItemRemoved(position);
            }
        });
        builder.setNegativeButton("Tidak", null);
        builder.create().show();
    }
}
