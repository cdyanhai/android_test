package com.example.yanxiaoyong.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yanxiaoyong.myapplication.fragment.FragmentView2;
import com.example.yanxiaoyong.myapplication.fragment.FragmentView3;
import com.example.yanxiaoyong.myapplication.fragment.Fragment_View1;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends AppCompatActivity {

    private Fragment view1,view2,view3;
    private ViewPager viewPager;
    private List<Fragment> viewList;
    private TabLayout mTablyout;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        mTablyout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        //LayoutInflater layoutInflater = getLayoutInflater();
//        view1 = layoutInflater.inflate(R.layout.layout1,null);
//        view2 = layoutInflater.inflate(R.layout.layout2,null);
//        view3 = layoutInflater.inflate(R.layout.layout3,null);
        view1 = new Fragment_View1();
        view2 = new FragmentView2();
        view3 = new FragmentView3();

        viewList = new ArrayList<Fragment>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            private String[] mTitles = new String[]{"第一页", "第二页", "第三页"};

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return viewList.get(arg0);
            }

            //            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view == object;
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                //super.destroyItem(container, position, object);
//               // container.removeView(viewList.get(position));
//            }
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                container.addView(viewList.get(position));
//                //return super.instantiateItem(container, position);
//                return viewList.get(position);
//            }


            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        };

        viewPager.setAdapter(pagerAdapter);

        mTablyout.setupWithViewPager(viewPager);
        one = mTablyout.getTabAt(0);
        two = mTablyout.getTabAt(1);
        three = mTablyout.getTabAt(2);

        one.setIcon(getResources().getDrawable(R.drawable.ic_android_black));
        two.setIcon(getResources().getDrawable(R.drawable.ic_assignment_return_black));
        three.setIcon(getResources().getDrawable(R.drawable.ic_face_black));

//          one.setIcon(getResources().getDrawable(R.mipmap.a));
//          two.setIcon(getResources().getDrawable(R.mipmap.b));
//          three.setIcon(getResources().getDrawable(R.mipmap.c));

      }
}
