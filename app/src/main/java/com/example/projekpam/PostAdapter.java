package com.example.projekpam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList;
    private Context context;

    public PostAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.textViewTitle.setText(post.getTitle());
        holder.textViewContent.setText(post.getContent());

        holder.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof CommunityActivity) {
                    ((CommunityActivity) context).editPost(post, position);
                }
            }
        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof CommunityActivity) {
                    ((CommunityActivity) context).deletePost(post, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewContent;
        Button buttonEdit;
        Button buttonDelete;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewContent = itemView.findViewById(R.id.textViewContent);
            buttonEdit = itemView.findViewById(R.id.buttonEdit);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
