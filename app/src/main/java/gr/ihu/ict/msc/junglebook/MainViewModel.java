package gr.ihu.ict.msc.junglebook;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import gr.ihu.ict.msc.junglebook.client.PhotoApiClient;
import gr.ihu.ict.msc.junglebook.model.Photo;

public class MainViewModel extends ViewModel {
    MutableLiveData<List<Photo>> photoList;
    PhotoApiClient photoApiClient = new PhotoApiClient();
    public LiveData<List<Photo>> getPhotos() {
        if (photoList == null) {
            this.photoList = new MutableLiveData<>();
            photoApiClient.getAllPhotos(photoList);
        }
        return this.photoList;
    }
    public LiveData<List<Photo>> updatePhotos() {
        photoApiClient.getAllPhotos(photoList);
        return this.photoList;
    }

}
