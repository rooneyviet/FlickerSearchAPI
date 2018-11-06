package jp.ventures.stv.stv19skilltest2018_flicker.Presenter;

import android.view.View;

import jp.ventures.stv.stv19skilltest2018_flicker.Model.FlickerAPIImplement;
import jp.ventures.stv.stv19skilltest2018_flicker.View.FlickerView;
import jp.ventures.stv.stv19skilltest2018_flicker.View.FlickerView.FlickerAPIResultListener;
import jp.ventures.stv.stv19skilltest2018_flicker.View.FlickerView.FlickerActivityListener;
import jp.ventures.stv.stv19skilltest2018_flicker.Model.Object.Photo;
import jp.ventures.stv.stv19skilltest2018_flicker.Utils.InternetCheck;

public class FlickerPresenter implements FlickerView.FlickerAPIResultListener, InternetCheck.CheckForInternet {
    private FlickerView.FlickerActivityListener flickerActivityListener;
    private FlickerView.FlickerAPIResultListener flickerAPIResultListener;

    public FlickerPresenter(FlickerActivityListener flickerActivityListener, FlickerAPIResultListener flickerAPIResultListener) {
        this.flickerActivityListener = flickerActivityListener;
        this.flickerAPIResultListener = flickerAPIResultListener;
    }


    public void checkInternet() {
        new InternetCheck(this);
    }

    public void searchAction() {
        String querySearch = flickerActivityListener.getSearchQuery().trim();
        if (!querySearch.isEmpty() || !querySearch.equals("")) {
            FlickerAPIImplement.searcPhotos(querySearch, this);
            flickerActivityListener.setToolbarText(querySearch);
        }
    }

    @Override
    public void notFoundAny() {
        flickerActivityListener.setErrorMessage("該当する写真がありません。検索ワードを変更してお試しください。");
    }

    @Override
    public void foundPhotoListListFromAPI(Photo[] photosList) {
        flickerAPIResultListener.foundPhotoListListFromAPI(photosList);
    }


    @Override
    public void apiFailed() {

    }

    @Override
    public void checkIfThereIsInternet(Boolean internet) {
        flickerActivityListener.checkInternet(internet);
    }
}