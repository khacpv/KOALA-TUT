package is.cinnamon.tuya;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;

import com.viewpagerindicator.PageIndicator;

import java.lang.reflect.Field;

import butterknife.Bind;
import butterknife.ButterKnife;
import is.cinnamon.tuya.common.views.viewpager.SCUtil;
import is.cinnamon.tuya.common.views.viewpager.SCViewAnimation;
import is.cinnamon.tuya.common.views.viewpager.SCViewPager;
import is.cinnamon.tuya.common.views.viewpager.SCViewPagerAdapter;

public abstract class SCViewPagerActivity extends AppCompatActivity {

    public SCViewPagerAdapter mPageAdapter;

    @Bind(R.id.pagerMain)
    public SCViewPager pagerMain;

    @Bind(R.id.dotMain)
    public PageIndicator dotMain;

    protected Point size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initSCViewPager();

        size = SCUtil.getDisplaySize(this);

        initViews();

        pagerMain.setCycle(false);
        pagerMain.setInterval(5000);
        pagerMain.startAutoScroll(2000);
        pagerMain.setStopScrollWhenTouch(true);

        try {
            final Field mScroller;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            final FixedSpeedScroller scroller = new FixedSpeedScroller(pagerMain.getContext(), new LinearInterpolator());
            scroller.setFixedDuration(1000);
            mScroller.set(pagerMain, scroller);

            pagerMain.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    pagerMain.stopAutoScroll();
                    scroller.setFixedDuration(200);
                    try {
                        mScroller.set(pagerMain, scroller);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                }
            });
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }
    }

    protected abstract void initViews();

    protected int getNumPages(){
        return 0;
    }

    protected void addPagerAnimation(SCViewAnimation anim){
        pagerMain.addAnimation(anim);
    }

    protected void setOnPageChangeListener(ViewPager.OnPageChangeListener listener){
        dotMain.setOnPageChangeListener(listener);
    }

    private void initSCViewPager(){

        mPageAdapter = new SCViewPagerAdapter(getSupportFragmentManager());
        mPageAdapter.setNumberOfPage(getNumPages());
        pagerMain.setAdapter(mPageAdapter);

        dotMain.setViewPager(pagerMain);

    }

    public class FixedSpeedScroller extends Scroller {

        private int mDuration = 5000;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }


        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        public void setFixedDuration(int duration){
            this.mDuration = duration;
        }
    }
}
