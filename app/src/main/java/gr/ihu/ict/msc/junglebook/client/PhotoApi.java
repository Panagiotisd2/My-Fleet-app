package gr.ihu.ict.msc.junglebook.client;


import java.util.List;

import gr.ihu.ict.msc.junglebook.model.Photo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoApi {

    @GET("/photos")
    Call<List<Photo>> getAllPhotos();

}
