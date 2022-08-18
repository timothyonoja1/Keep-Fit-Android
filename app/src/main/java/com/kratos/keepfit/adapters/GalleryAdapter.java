package com.kratos.keepfit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.Gallery;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryHolder> {

    private final List<Gallery> galleries;

    public GalleryAdapter(List<Gallery> galleries){
        this.galleries = galleries;
    }

    protected static class GalleryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView galleryImageView;
        private Gallery gallery;

        public GalleryHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            galleryImageView = itemView.findViewById(R.id.gallery_image_view);
        }

        public void bind(Gallery gallery){
            this.gallery = gallery;
            galleryImageView.setImageDrawable(gallery.getDrawableResource());
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public GalleryHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_gallery, viewGroup, false);
        return new GalleryHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryHolder holder, final int position) {
        holder.bind(galleries.get(position));
    }

    @Override
    public int getItemCount() {
        return galleries.size();
    }
}