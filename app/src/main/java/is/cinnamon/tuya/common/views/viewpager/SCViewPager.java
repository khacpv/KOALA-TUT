package is.cinnamon.tuya.common.views.viewpager;

import android.content.Context;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class SCViewPager extends AutoScrollViewPager {
    private List<SCViewAnimation> mViewAnimation = new ArrayList();

    public SCViewPager(Context context) {
        super(context);
    }

    public SCViewPager(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public void addAnimation(SCViewAnimation inViewAnimation) {
        this.mViewAnimation.add(inViewAnimation);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);

        for(int i = 0; i < this.mViewAnimation.size(); ++i) {
            ((SCViewAnimation)this.mViewAnimation.get(i)).applyAnimation(position, positionOffset);
        }

    }
}
