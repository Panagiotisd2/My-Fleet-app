package gr.ihu.ict.msc.junglebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import gr.ihu.ict.msc.junglebook.R;
import gr.ihu.ict.msc.junglebook.model.Photo;

public class MainActivity extends AppCompatActivity {

    List<Photo> photoList = Arrays.asList(
            new Photo("Giraffe", R.drawable.giraffe, "Long necks"),
            new Photo("Caracara", R.drawable.caracara, "Strange birds"),
            new Photo("Elephant", R.drawable.elephant, "Remember Everything"),
            new Photo("Gnu", R.drawable.gnu, "Gnu is not unix"),
            new Photo("Hippo", R.drawable.hippo,"Fast runners"),
            new Photo("Ostrich", R.drawable.ostrich,"Other fast runners"),
            new Photo("Panda", R.drawable.panda,"Cure bears"),
            new Photo("Tiger", R.drawable.tiger,"Large cats"),
            new Photo("Zebra", R.drawable.zebra, "Horses with barcodes")
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.photoRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        PhotoRecyclerAdapter photoRecyclerAdapter = new PhotoRecyclerAdapter(photoList,
                findViewById(R.id.helloMessage));
        recyclerView.setAdapter(photoRecyclerAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

     public void onClickHandler(View view) {
           ImageView animalImage =  findViewById(R.id.helloMessage);
           if (animalImage.getVisibility() == View.VISIBLE) {
               animalImage.setVisibility(View.INVISIBLE);
           } else {
               animalImage.setVisibility(View.VISIBLE);
           }
     }
}