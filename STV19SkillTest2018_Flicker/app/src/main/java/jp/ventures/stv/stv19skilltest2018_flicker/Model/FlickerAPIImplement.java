package jp.ventures.stv.stv19skilltest2018_flicker.Model;

import android.util.Log;

import jp.ventures.stv.stv19skilltest2018_flicker.FlickerAPI.FlickerAPIClient;
import jp.ventures.stv.stv19skilltest2018_flicker.FlickerAPI.FlickerAPIDAO;
import jp.ventures.stv.stv19skilltest2018_flicker.Model.Object.FlickerResponseObject;
import jp.ventures.stv.stv19skilltest2018_flicker.View.FlickerView;
import retrofit2.Call;
import jp.ventures.stv.stv19skilltest2018_flicker.Utils.Constants;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickerAPIImplement {
    public static void searcPhotos(String searchQuery,final FlickerView.FlickerAPIResultListener flickerAPIResultListener){
        FlickerAPIDAO flickerAPIDAO = FlickerAPIClient.getClient().create(FlickerAPIDAO.class);

        Call<FlickerResponseObject> ituneCall = flickerAPIDAO.searchPhotos(Constants.METHOD, Constants.API_KEY,Constants.FORMAT,Constants.nojsoncallback,searchQuery,50);

        ituneCall.enqueue(new Callback<FlickerResponseObject>() {
            @Override
            public void onResponse(Call<FlickerResponseObject> call, Response<FlickerResponseObject> response) {
                Log.d("responseCode", String.valueOf(response.code()));
                Log.d("!repsn",response.toString());

                if(response.body().getPhotos().getTotal().equals("0")){
                    flickerAPIResultListener.notFoundAny();
                }else{
                    flickerAPIResultListener.foundPhotoListListFromAPI(response.body().getPhotos().getPhoto());

                }
            }

            @Override
            public void onFailure(Call<FlickerResponseObject> call, Throwable t) {

            }
        });

        /*ituneCall.enqueue(new Callback<FlickerResponseObject>() {
            @Override
            public void onResponse(Call<ItuneResultList> call, Response<ItuneResultList> response) {

                Log.d("responseCode", String.valueOf(response.code()));
                Log.d("!repsn",response.toString());

                if(response.body().getResultCount()==0){
                    ituneAPIResultListener.notFoundAny();
                }else{
                    ituneAPIResultListener.foundItunesListFromAPI(response.body().getItuneResultList());
                    Log.d("resultCount", String.valueOf(response.body().getResultCount()));
                }
            }

            @Override
            public void onFailure(Call<ItuneResultList> call, Throwable t) {
                ituneAPIResultListener.apiFailed();
            }
        });*/
    }
}
