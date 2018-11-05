package jp.ventures.stv.stv19skilltest2018_flicker.View;

import jp.ventures.stv.stv19skilltest2018_flicker.Model.Object.Photo;

public class FlickerView {
    public interface FlickerActivityListener{

        String getSearchQuery();

        void setButton(boolean clickable);

        void checkInternet(boolean onOff);

        void setToolbarText(String searchQuery);

        void showProgressBar();

        void hideProgressBar();

        void setErrorMessage(String errorMessage);
    }


    public interface FlickerAPIResultListener{
        void notFoundAny();

        void foundPhotoListListFromAPI(Photo[] photosList);

        void apiFailed();
    }
}
