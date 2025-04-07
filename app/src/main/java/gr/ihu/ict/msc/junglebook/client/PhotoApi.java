package gr.ihu.ict.msc.junglebook.client;


import java.util.List;

import gr.ihu.ict.msc.junglebook.model.Photo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PhotoApi {

    @GET("/photos")
    Call<List<Photo>> getAllPhotos();

    @POST("/photos")
    Call<Photo> addPhoto(@Body Photo photo);

}
