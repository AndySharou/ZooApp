package com.example.andrew.zooapp.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrew.zooapp.R;
import com.example.andrew.zooapp.fragments.tabs.AddressTabFragment;
import com.example.andrew.zooapp.fragments.tabs.ClubsTabFragment;
import com.example.andrew.zooapp.fragments.tabs.ExcursionsTabFragment;
import com.example.andrew.zooapp.fragments.tabs.HorseRidingTabFragment;
import com.example.andrew.zooapp.fragments.tabs.RegulationsTabFragment;
import com.example.andrew.zooapp.fragments.tabs.WorkingHoursTabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 24.11.2016.
 */

public class VisitorInformationFragment extends Fragment {

    public static VisitorInformationFragment getInstance() {
        VisitorInformationFragment fragment = new VisitorInformationFragment();
        return fragment;

    }


    private TabLayout tabLayout;
    private ViewPager viewPager;

    public VisitorInformationFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_visitor_information, container, false);
        //return inflater.inflate(R.layout.fragment_visitor_information, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new WorkingHoursTabFragment(), getString(R.string.working_hours_tab));
        adapter.addFragment(new AddressTabFragment(), getString(R.string.address_tab));
        adapter.addFragment(new ExcursionsTabFragment(), getString(R.string.excursions_tab));
        adapter.addFragment(new ClubsTabFragment(), getString(R.string.clubs_tab));
        adapter.addFragment(new HorseRidingTabFragment(), getString(R.string.horse_riding_tab));
        adapter.addFragment(new RegulationsTabFragment(), getString(R.string.regulations_tab));
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
