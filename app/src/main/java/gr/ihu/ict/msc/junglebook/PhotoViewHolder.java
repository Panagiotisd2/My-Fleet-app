package gr.ihu.ict.msc.junglebook;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    TextView animalName;
    TextView shortDescription;
    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        animalName = itemView.findViewById(R.id.animalName);
        shortDescription = itemView.findViewById(R.id.textView2);
    }
}

