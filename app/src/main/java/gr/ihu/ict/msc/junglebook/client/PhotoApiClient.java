package gr.ihu.ict.msc.junglebook.client;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;

import gr.ihu.ict.msc.junglebook.CreateViewModel;
import gr.ihu.ict.msc.junglebook.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class PhotoApiClient {

    private static final String BASE_URL="http://10.0.2.2:8000";
    private final PhotoApi photoApi;

    public PhotoApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(
                        new ObjectMapper()
                )).build();

        photoApi = retrofit.create(PhotoApi.class);

    }
    public void getAllPhotos( MutableLiveData<List<Photo>> photoList) {
        Call<List<Photo>> allPhotos = photoApi.getAllPhotos();

        allPhotos.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call, @NonNull Response<List<Photo>> response) {
                if (response.body()!=null) {
                    photoList.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call, @NonNull Throwable throwable) {
                photoList.postValue(Collections.emptyList());
            }
        });
    }

    public void addPhoto(CreateViewModel viewModel, Photo photo) {
        Call<Photo> addPhotoCall = photoApi.addPhoto(photo);

        addPhotoCall.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if (response.body()!=null) {
                    viewModel.updateFromRest(photo);
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable throwable) {
                Log.e("REST Client",
                        "Tried to post photo but got back:" + throwable.getLocalizedMessage());
                viewModel.FailedFromRest(throwable.getLocalizedMessage());
            }
        });
    }
    public MutableLiveData<List<Photo>> getFilteredPhotos(String filterSelection, MutableLiveData<List<Photo>> photoList) {

        Call<List<Photo>> call = photoApi.findByType(filterSelection);

        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.body() != null) {
                    photoList.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.e("REST Client",
                        "Tried to get all photos{}. Got back " + t.getLocalizedMessage());
                photoList.postValue(Collections.emptyList());
            }
        });
        return photoList;
    }
}
