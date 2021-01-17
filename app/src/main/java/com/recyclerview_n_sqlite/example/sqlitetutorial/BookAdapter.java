package com.recyclerview_n_sqlite.example.sqlitetutorial;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private static final String TAG = "BookAdapter";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImgUrls = new ArrayList<>();
    private Context mContext;

    public BookAdapter(Context mContext, ArrayList<String> mNames, ArrayList<Integer> mImgUrls) {
        this.mNames = mNames;
        this.mImgUrls = mImgUrls;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horiz_recycler_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mContext).asBitmap().load(mImgUrls.get(position)).into(holder.img_book);
        holder.txt_title.setText(mNames.get(position));
        holder.img_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: cliked on image: "+mNames.get(position));
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImgUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_book;
        TextView txt_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_book = itemView.findViewById(R.id.img_book);
            txt_title = itemView.findViewById(R.id.txt_title);
        }
    }
}
