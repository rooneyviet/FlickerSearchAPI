package jp.ventures.stv.stv19skilltest2018_flicker.FlickerAPI;

import jp.ventures.stv.stv19skilltest2018_flicker.Model.Object.FlickerResponseObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickerAPIDAO {
    @GET("/services/rest/")
    //https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=92f3fd8101d1d3a3613339d37c0452b9&format=json&nojsoncallback=1&text=ios
    Call<FlickerResponseObject> searchPhotos(@Query("method") String method, @Query("api_key") String apikey,@Query("format") String json, @Query("nojsoncallback") String one,@Query("text") String searchQuery,@Query("per_page") int litmitperpage);

}
