package is.cinnamon.tuya.common.views.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class SCViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<SCViewPagerFragment> mFragmentList = new ArrayList();
    private int mNumberOfPage = 0;
    private int mBackgroundColor;

    public SCViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setNumberOfPage(int numberOfPage) {
        this.mNumberOfPage = numberOfPage;
    }

    public void setFragmentBackgroundColor(int colorResource) {
        this.mBackgroundColor = colorResource;
    }

    public Fragment getItem(int position) {
        SCViewPagerAdapter.SCViewPagerFragment fragment = null;
        if(this.mFragmentList.size() - 1 >= position) {
            fragment = (SCViewPagerAdapter.SCViewPagerFragment)this.mFragmentList.get(position);
        }

        if(fragment == null) {
            fragment = new SCViewPagerAdapter.SCViewPagerFragment();
            fragment.setBackground(this.mBackgroundColor);
        }

        return fragment;
    }

    public int getCount() {
        return this.mNumberOfPage;
    }

    public static class SCViewPagerFragment extends Fragment {
        private int color;

        public SCViewPagerFragment() {
            this.color = Color.WHITE;
        }

        public void setBackground(int inColor) {
            this.color = inColor;
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout view = new LinearLayout(this.getActivity());
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            view.setOrientation(LinearLayout.HORIZONTAL);
            view.setBackgroundColor(this.color);
            return view;
        }

        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }
    }
}
