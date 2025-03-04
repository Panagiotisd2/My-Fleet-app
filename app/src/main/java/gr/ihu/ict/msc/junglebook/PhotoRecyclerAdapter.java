package gr.ihu.ict.msc.junglebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.ihu.ict.msc.junglebook.model.Photo;

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private final ImageView imageView;
    List<Photo> photoList;

    public PhotoRecyclerAdapter(List<Photo> photoList, ImageView imageView) {
        this.photoList = photoList;
        this.imageView = imageView;
    }
    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.photo_recycler_item, parent, false);

        return new PhotoViewHolder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = photoList.get(position);
        TextView  textView = holder.animalName;
        textView.setText(photo.getName());
        TextView shortDescription = holder.shortDescription;
        shortDescription.setText(photo.getDescription().substring(0,4));
        textView.setOnClickListener(view -> imageView.setImageResource(photo.getId()));
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
