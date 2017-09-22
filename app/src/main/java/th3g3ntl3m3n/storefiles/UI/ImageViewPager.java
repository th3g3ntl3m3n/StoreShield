package th3g3ntl3m3n.storefiles.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import th3g3ntl3m3n.storefiles.ImageData.ImageData;
import th3g3ntl3m3n.storefiles.R;

/**
 * Created by th3g3ntl3m3n on 15/9/17.
 */

public class ImageViewPager extends Fragment {

    private static ArrayList<ImageData> arrayList;

    public static Fragment newInstace(ArrayList<ImageData> images) {
        arrayList = images;
        return new ImageViewPager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_view_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.imageViewPager);
        ImagesPagerAdapter adapter = new ImagesPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1, true);
    }

    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    class ImagesPagerAdapter extends FragmentStatePagerAdapter {
        private String[] arrayOfTitles = {"Login/Register", "Post Ads", "Browse Ads", "Frequently Asked Questions", "Contact Us", "Terms & Conditions"};

        public ImagesPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ImageViewFragment.newInstance(arrayList.get(position).getUrl(), arrayList.get(position).getUrl());
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }
    }
}
