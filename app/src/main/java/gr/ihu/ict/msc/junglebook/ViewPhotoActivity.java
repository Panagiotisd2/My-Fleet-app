package gr.ihu.ict.msc.junglebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import gr.ihu.ict.msc.junglebook.model.Photo;

public class ViewPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_photo);

        Intent intent = getIntent();
        if (intent!=null) {
            Photo photo = (Photo) intent.getSerializableExtra("photo");
            if (photo!=null) {
                ImageView imageView = findViewById(R.id.imageView);
                Bitmap bitmap = BitmapFactory.decodeByteArray(photo.getData(), 0, photo.getData().length);
                imageView.setImageBitmap(bitmap);
                TextView textView = findViewById(R.id.descriptionView);
                textView.setText(photo.getDescription());
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}