package jp.ventures.stv.stv19skilltest2018_flicker.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.ventures.stv.stv19skilltest2018_flicker.FlickerAPI.FlickerAPIDAO;
import jp.ventures.stv.stv19skilltest2018_flicker.Presenter.FlickerPresenter;
import jp.ventures.stv.stv19skilltest2018_flicker.R;
import jp.ventures.stv.stv19skilltest2018_flicker.View.FlickerView.FlickerAPIResultListener;
import jp.ventures.stv.stv19skilltest2018_flicker.Model.Object.Photo;
import jp.ventures.stv.stv19skilltest2018_flicker.Utils.InternetOffErrorDialogFragment;

public class FlickerActivity extends AppCompatActivity implements FlickerAPIResultListener, FlickerView.FlickerActivityListener{

    private RecyclerView flickerRecyclerView;
    private SearchView searchEditText;
    private TextView cannotFindSongText, toolbarText;
    private Button cancelButton;
    private FlickerAdapter flickerAdapter;

    private Photo[] photos;
    private List<Photo> photoList;

    private FlickerAPIDAO flickerAPIDAO;

    private ProgressBar searchingProgressBar;

    String newQuery;

    private FlickerPresenter flickerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flicker);

        setupResourse();

        setupAdapterAndRecyclerView();

        pressEnterInKeyboard();

        cancelButtonAction();


    }

    private void setupAdapterAndRecyclerView() {
        flickerAdapter = new FlickerAdapter(photoList,FlickerActivity.this);
        flickerRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        flickerRecyclerView.setAdapter(flickerAdapter);
    }

    private void setupResourse(){
        flickerRecyclerView = findViewById(R.id.flickerRecyclerView);
        searchEditText = findViewById(R.id.searchPhotosEditText);
        cannotFindSongText = findViewById(R.id.cannotFindPhotosText);
        cancelButton = findViewById(R.id.cancelButton);
        searchingProgressBar = findViewById(R.id.searchingProgressBar);
        searchingProgressBar.setVisibility(View.GONE);
        toolbarText = findViewById(R.id.toolbarText);

       photos = new Photo[50];
        photoList = new ArrayList<>();

        cancelButton.setEnabled(false);

        flickerPresenter = new FlickerPresenter(this,this);
    }

    private void pressEnterInKeyboard(){
        searchEditText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                newQuery = query;
                flickerPresenter.checkInternet();
                closeKeyboard();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchEditText.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchEditText.clearFocus();
                return false;
            }
        });

        searchEditText.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    cancelButton.setEnabled(true);
                }else {
                    cancelButton.setEnabled(false);
                }
            }
        });

        searchEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchEditText.setIconified(false);
            }
        });
    }



    private void cancelButtonAction() {
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });
    }

    private void closeKeyboard(){
        cancelButton.setEnabled(false);

        searchEditText.clearFocus();
    }

    private void showOfflineDialog(){
        InternetOffErrorDialogFragment dialogFragment = new InternetOffErrorDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "dialog_fragment");
    }

    @Override
    public String getSearchQuery() {
        return newQuery;
    }

    @Override
    public void setButton(boolean clickable) {

    }


    @Override
    public void checkInternet(boolean onOff) {
        if(onOff){
            flickerRecyclerView.setVisibility(View.VISIBLE);
            cannotFindSongText.setVisibility(View.GONE);
            searchingProgressBar.setVisibility(View.VISIBLE);

            flickerPresenter.searchAction();

            //photos.clear();
            photoList.clear();
            flickerAdapter.notifyDataSetChanged();
        }else {
            showOfflineDialog();
        }
    }

    @Override
    public void setToolbarText(String searchQuery) {
        toolbarText.setText(searchQuery);
    }

    @Override
    public void showProgressBar() {
        searchingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        searchingProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        cannotFindSongText.setVisibility(View.VISIBLE);
        photoList.clear();
        flickerAdapter.notifyDataSetChanged();

        cannotFindSongText.setText(errorMessage);
        searchingProgressBar.setVisibility(View.GONE);
    }


    @Override
    public void notFoundAny() {

    }

    @Override
    public void foundPhotoListListFromAPI(Photo[] photosList) {
        flickerRecyclerView.setVisibility(View.VISIBLE);
        cannotFindSongText.setVisibility(View.GONE);

        //photosList = Arrays.asList(photos).toArray(new Photo[50]);
        searchingProgressBar.setVisibility(View.GONE);
        List<Photo> list = new ArrayList(Arrays.asList(photosList));
        flickerAdapter.setPhotoList(list);
        flickerAdapter.notifyDataSetChanged();
    }

    @Override
    public void apiFailed() {

    }
}
