package is.cinnamon.tuya.common.views.viewpager;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.View;

public class SCUtil {

    private static int width;
    private static int height;

    public SCUtil() {
    }

    public static void prepareViewToGetSize(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static Point getDisplaySize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        return size;
    }

    public static int widthHalf(){
        return width/2;
    }

    public static int heightHalf(){
        return height/2;
    }

    public static int widthThird(){
        return width/3;
    }

    public static int heightThird(){
        return height/3;
    }

    public static int widthQuart(){
        return width/4;
    }

    public static int heightQuart(){
        return height/4;
    }
}
