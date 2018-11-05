package jp.ventures.stv.stv19skilltest2018_flicker.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.ventures.stv.stv19skilltest2018_flicker.Model.Object.Photo;
import jp.ventures.stv.stv19skilltest2018_flicker.R;

public class FlickerAdapter extends RecyclerView.Adapter<FlickerAdapter.FlickerImageHolder>{
   private List<Photo> photoList;

    private Context context;

    public FlickerAdapter(List<Photo> photoList, Context context) {
        this.photoList = photoList;
        this.context = context;
    }

    @NonNull
    @Override
    public FlickerAdapter.FlickerImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flicker_photo_row,parent,false);
        return new FlickerImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlickerAdapter.FlickerImageHolder holder, int position) {

       // Photo photoResult = photos[position];
        Photo photo = photoList.get(position);

        String uriString="https://farm"+photo.getFarm()+".staticflickr.com/"+
                photo.getServer()+"/"+
                photo.getId()+"_" +
                photo.getSecret()+".jpg";

        Picasso.with(context)
                .load(uriString)
                .into(holder.flickerImage);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class FlickerImageHolder extends RecyclerView.ViewHolder{
        ImageView flickerImage;
        public FlickerImageHolder(View itemView) {
            super(itemView);
            flickerImage = itemView.findViewById(R.id.flickerImage);
        }
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}
