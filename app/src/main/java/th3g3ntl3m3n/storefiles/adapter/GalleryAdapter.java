package th3g3ntl3m3n.storefiles.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import th3g3ntl3m3n.storefiles.ImageData.ImageData;
import th3g3ntl3m3n.storefiles.R;
import th3g3ntl3m3n.storefiles.UI.ImageViewPager;

/**
 * Created by th3g3ntl3m3n on 31/8/17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>{

    private static int overlayColor,transparent;
    private static int toggle = 0;
    Context mcontext;
    private ArrayList<ImageData> list;
    private FragmentManager fragmentManager;

    public GalleryAdapter(ArrayList<ImageData> list, Context context, FragmentManager fragmentManager) {
        this.list = list;
        mcontext = context;
        this.fragmentManager = fragmentManager;
        overlayColor = mcontext.getResources().getColor(R.color.overlay);
        transparent = mcontext.getResources().getColor(android.R.color.transparent);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(mcontext)
                .load(list.get(holder.getAdapterPosition()).getUrl())
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.fragment_container, ImageViewPager.newInstace(list))
                        .addToBackStack("hello").commit();
            }
        });

        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                boolean selected = list.get(holder.getAdapterPosition()).isSelected();
                if(selected) {
                    holder.l1.setBackgroundColor(transparent);
                    list.get(holder.getAdapterPosition()).setSelected(false);
                } else {
                    holder.l1.setBackgroundColor(overlayColor);
                    list.get(holder.getAdapterPosition()).setSelected(true);
                }
                return true;
            }
        });
    }

    public void updateDataSet(ArrayList<ImageData> bitmapArrayList) {
        list = bitmapArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        LinearLayout l1;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgThumb);
            l1 = itemView.findViewById(R.id.overlay);
        }
    }
}
