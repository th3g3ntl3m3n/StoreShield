package th3g3ntl3m3n.storefiles.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import th3g3ntl3m3n.storefiles.R;

/**
 * Created by th3g3ntl3m3n on 15/9/17.
 */

public class ImageViewFragment extends Fragment {

    private static String heading;
    private static String uriOfImage;

    public static Fragment newInstance(String text, String uri) {
        heading = text;
        uriOfImage = uri;
        return new ImageViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.preview_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.heading);
        ImageView imageView = view.findViewById(R.id.preview_image);
        Glide.with(view).load(uriOfImage).into(imageView);
        textView.setText(uriOfImage);
    }

    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
