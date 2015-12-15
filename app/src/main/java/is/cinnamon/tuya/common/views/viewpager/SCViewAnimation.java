package is.cinnamon.tuya.common.views.viewpager;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SCViewAnimation {
    private View view;
    private HashMap<Integer, ArrayList<SCPageAnimation>> pageAnimationMap;

    public SCViewAnimation(View inView) {
        this.view = inView;
        this.pageAnimationMap = new HashMap();
    }

    public void startToAlpha(Float alpha){
        if(alpha != null){
            this.view.setAlpha(alpha.floatValue());
        }
        this.view.invalidate();
    }

    public void startToPosition(Integer xPosition, Integer yPosition) {
        if(xPosition != null) {
            this.view.setX((float)xPosition.intValue());
        }

        if(yPosition != null) {
            this.view.setY((float)yPosition.intValue());
        }

        this.view.requestLayout();
    }

    public void startToScale(Float xScale,Float yScale){
        if(xScale != null){
            this.view.setScaleX(xScale);
        }
        if(yScale != null){
            this.view.setScaleY(yScale);
        }
        this.view.requestLayout();
    }

    public void startToAngle(Float angle){
        if(angle != null){
            this.view.setRotation(angle);
        }
        this.view.requestLayout();
        this.view.invalidate();
    }

    public void addPageAnimation(SCPageAnimation inPageAnimation) {
        ArrayList animationList = (ArrayList)this.pageAnimationMap.get(Integer.valueOf(inPageAnimation.page));
        if(animationList == null) {
            animationList = new ArrayList();
        }

        animationList.add(inPageAnimation);
        this.pageAnimationMap.put(Integer.valueOf(inPageAnimation.page), animationList);
    }

    public void applyAnimation(int page, float positionOffset) {
        ArrayList animationList = (ArrayList)this.pageAnimationMap.get(Integer.valueOf(page));
        if(animationList != null) {
            Iterator i$ = animationList.iterator();

            while(i$.hasNext()) {
                SCPageAnimation animation = (SCPageAnimation)i$.next();
                animation.applyTransformation(this.view, positionOffset);
            }

        }
    }
}
