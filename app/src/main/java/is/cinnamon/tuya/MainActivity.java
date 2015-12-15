package is.cinnamon.tuya;

import android.content.Intent;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import is.cinnamon.tuya.common.views.viewpager.SCPageAnimation;
import is.cinnamon.tuya.common.views.viewpager.SCUtil;
import is.cinnamon.tuya.common.views.viewpager.SCViewAnimation;
import is.cinnamon.tuya.common.views.viewpager.interpolator.SCLinearInterpolator;
import is.cinnamon.tuya.common.views.viewpager.interpolator.SCParabolInterpolator;

/**
 * Created by khacpham on 11/25/15.
 */
public class MainActivity extends SCViewPagerActivity {

    protected static final int NUM_PAGES = 4;

    protected static final int PAGE_0 = 0;
    protected static final int PAGE_1 = 1;
    protected static final int PAGE_2 = 2;
    protected static final int PAGE_3 = 3;

    @Bind(R.id.loginBtn)
    public Button loginBtn;

    @Bind(R.id.capture)
    public View capture;

    @Bind(R.id.picture)
    public View picture;

    @Bind(R.id.overlay)
    public View overlay;

    @Bind(R.id.mobileNormal)
    public View mobileNormal;

    @Bind(R.id.thumb00)
    public View thumb00;

    @Bind(R.id.frame)
    public View frame;

    @Bind(R.id.megaText01)
    public View megaText01;

    @Bind(R.id.megaText02)
    public View megaText02;

    @Bind(R.id.pictureSend)
    public View pictureSend;

    @Bind(R.id.contact01)
    public View contact01;

    @Bind(R.id.contact02)
    public View contact02;

    @Bind(R.id.contact03)
    public View contact03;

    @Bind(R.id.contact04)
    public View contact04;

    @Bind(R.id.contact05)
    public View contact05;

    @Bind(R.id.contact06)
    public View contact06;

    @Bind(R.id.contact07)
    public View contact07;

    @Bind(R.id.introCamera)
    public View introCamera;

    @Bind(R.id.introEdit)
    public View introEdit;

    @Bind(R.id.introSend)
    public View introSend;

    @Override
    protected void initViews() {

        // TODO capture
        SCViewAnimation captureAnim = new SCViewAnimation(capture);
        captureAnim.startToAlpha(0f);
        captureAnim.addPageAnimation(new SCPageAnimation(PAGE_0) {
            SCParabolInterpolator interpolation = new SCParabolInterpolator();

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interpolation.apply(offset));
            }
        });
        addPagerAnimation(captureAnim);

        // TODO overlay
        SCViewAnimation overlayAnim = new SCViewAnimation(overlay);
        overlayAnim.startToAlpha(0f);
        overlayAnim.addPageAnimation(new SCPageAnimation(PAGE_0) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 0.99f, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
            }
        });
        overlayAnim.addPageAnimation(new SCPageAnimation(PAGE_1) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0.99f,0.99f,0f,1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
            }
        });
        addPagerAnimation(overlayAnim);

        // TODO mobileNormal
        SCViewAnimation mobileNormalAnim = new SCViewAnimation(mobileNormal);
        mobileNormalAnim.startToAlpha(0f);
        mobileNormal.setY(350f + SCUtil.heightHalf());
        mobileNormalAnim.addPageAnimation(new SCPageAnimation(PAGE_0) {

            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0.3f, 0.5f);

            @Override
            public void applyTransformation(View view, float offset) {
                if (offset < 0.1f) {
                    view.setAlpha(0);
                } else if (offset <= 0.5f) {
                    view.setAlpha(interAlpha.apply(offset));
                } else {
                    view.setAlpha(1f);
                }
                view.setY(350f + SCUtil.heightHalf());
            }
        });
        mobileNormalAnim.addPageAnimation(new SCPageAnimation(PAGE_1) {

            SCLinearInterpolator interAlpha = new SCLinearInterpolator(1f, 0f, 0f, 0.4f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
            }
        });
        addPagerAnimation(mobileNormalAnim);

        // TODO thumb
        SCViewAnimation thumb00Anim = new SCViewAnimation(thumb00);
        thumb00Anim.startToAlpha(0f);
        thumb00.setY(28f);
        thumb00.setX(size.x - 600);
        thumb00.requestLayout();
        thumb00.invalidate();
        thumb00Anim.addPageAnimation(new SCPageAnimation(PAGE_0) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(1f, 1f, 0.0f, 1f);
            SCLinearInterpolator interY = new SCLinearInterpolator(28f, 1360f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(size.x-600, size.x/2-106, 0f, 1f);
            SCLinearInterpolator interW = new SCLinearInterpolator(570f, 210f, 0f, 1f);
            SCLinearInterpolator interH = new SCLinearInterpolator(600f, 210f, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setY(interY.apply(offset));
                view.setX(interX.apply(offset));
                view.getLayoutParams().width = (int) interW.apply(offset);
                view.getLayoutParams().height = (int) interH.apply(offset);
                view.requestLayout();
            }
        });
        addPagerAnimation(thumb00Anim);

        // TODO introCamera
        SCViewAnimation introCameraAnim = new SCViewAnimation(introCamera);
        introCameraAnim.startToAlpha(0f);
        introCameraAnim.addPageAnimation(new SCPageAnimation(PAGE_0) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
            }
        });
        introCameraAnim.addPageAnimation(new SCPageAnimation(PAGE_1) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(1f, 0f, 0f, 0.3f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(introCameraAnim);

        // TODO thumb
        SCViewAnimation thumbAnim = new SCViewAnimation(thumb00);
        thumbAnim.startToAlpha(0f);
        thumbAnim.addPageAnimation(new SCPageAnimation(PAGE_1) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(1f,1f,0f,1f);
            SCLinearInterpolator interY = new SCLinearInterpolator(1360f,243f,0f,1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(size.x/2-106,23f,0f,1f);
            SCLinearInterpolator interW = new SCLinearInterpolator(210f,1030f,0f,1f);
            SCLinearInterpolator interH = new SCLinearInterpolator(210f,1070f,0f,1f);

            @Override
            public void applyTransformation(View view, float offset) {
                // position & alpha
                view.setY(interY.apply(offset));
                view.setX(interX.apply(offset));
                view.getLayoutParams().width = (int)interW.apply(offset);
                view.getLayoutParams().height = (int)interH.apply(offset);
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(thumbAnim);

        // TODO frame
        SCViewAnimation frameAnim = new SCViewAnimation(frame);
        frameAnim.startToAlpha(0f);
        frameAnim.addPageAnimation(new SCPageAnimation(PAGE_1) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interW = new SCLinearInterpolator(900f,900f,0f,1f);
            SCLinearInterpolator interH = new SCLinearInterpolator(900f,900f,0f,1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.getLayoutParams().width = (int)interW.apply(offset);
                view.getLayoutParams().height = (int)interH.apply(offset);
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(frameAnim);

        // TODO megaText01
        SCViewAnimation megaText01Anim = new SCViewAnimation(megaText01);
        megaText01Anim.startToAlpha(0f);
        megaText01Anim.addPageAnimation(new SCPageAnimation(PAGE_1) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(size.x+megaText01.getMeasuredWidth(), 0, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.getLayoutParams().width = 1000;
                view.getLayoutParams().height = 900;
                ((TextView)megaText01).setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                view.requestLayout();
            }
        });
        addPagerAnimation(megaText01Anim);

        // TODO megaText02
        SCViewAnimation megaText02Anim = new SCViewAnimation(megaText02);
        megaText02Anim.startToAlpha(0f);
        megaText02Anim.addPageAnimation(new SCPageAnimation(PAGE_1) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(-SCUtil.widthHalf() - megaText02.getMeasuredWidth(), 0, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.getLayoutParams().width = 1000;
                view.getLayoutParams().height = 900;
                ((TextView)megaText01).setTextSize(TypedValue.COMPLEX_UNIT_SP,36);
                view.requestLayout();
            }
        });
        addPagerAnimation(megaText02Anim);

        // TODO introEdit
        SCViewAnimation introEditAnim = new SCViewAnimation(introEdit);
        introEditAnim.startToAlpha(0f);
        introEditAnim.addPageAnimation(new SCPageAnimation(PAGE_1) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
            }
        });
        introEditAnim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(1f, 0f, 0f, 0.3f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(introEditAnim);

        // TODO thumb: page 2
        SCViewAnimation thumb2Anim = new SCViewAnimation(thumb00);
        thumb2Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interW = new SCLinearInterpolator(1030f,485f,0f,0.9f);
            SCLinearInterpolator interH = new SCLinearInterpolator(1070f,540f,0f,0.9f);
            SCLinearInterpolator interY = new SCLinearInterpolator(250,250,0f,1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(23f,size.x/2-210f,0f,1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setY(interY.apply(offset));
                view.getLayoutParams().width = (int) interW.apply(offset);
                view.getLayoutParams().height = (int) interH.apply(offset);
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(thumb2Anim);

        // TODO frame: page 2
        SCViewAnimation frame2Anim = new SCViewAnimation(frame);
        frame2Anim.startToAlpha(0f);
        frame2Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interW = new SCLinearInterpolator(900f,400f,0f,0.9f);
            SCLinearInterpolator interH = new SCLinearInterpolator(900f,400f,0f,0.9f);
            SCLinearInterpolator interY = new SCLinearInterpolator(250,250,0f,1f);

            @Override
            public void applyTransformation(View view, float offset) {
                if(offset<=0.9f) {
                    view.setY(interY.apply(offset));
                    view.getLayoutParams().width = (int) interW.apply(offset);
                    view.getLayoutParams().height = (int) interH.apply(offset);
                }else{
                    view.setY(250);
                    view.getLayoutParams().width = 420;
                    view.getLayoutParams().height= 400;
                }
                view.requestLayout();
            }
        });
        addPagerAnimation(frame2Anim);

        // TODO megaText1: page 2
        SCViewAnimation megaText01_02Anim = new SCViewAnimation(megaText01);
        megaText01_02Anim.startToAlpha(0f);
        megaText01_02Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interW = new SCLinearInterpolator(900f,400f,0f,0.9f);
            SCLinearInterpolator interH = new SCLinearInterpolator(900f,400f,0f,0.9f);
            SCLinearInterpolator interY = new SCLinearInterpolator(180,200,0f,1f);
            SCLinearInterpolator interSize = new SCLinearInterpolator(36f,18f,0f,1f);

            @Override
            public void applyTransformation(View view, float offset) {
                if(offset<=0.9f) {
                    view.setY(interY.apply(offset));
                    view.getLayoutParams().width = (int) interW.apply(offset);
                    view.getLayoutParams().height = (int) interH.apply(offset);
                    ((TextView)megaText01).setTextSize(TypedValue.COMPLEX_UNIT_SP,interSize.apply(offset));
                }else{
                    view.setY(200);
                    view.getLayoutParams().width = 420;
                    view.getLayoutParams().height= 400;
                    ((TextView)megaText01).setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                }
                view.requestLayout();
            }
        });
        addPagerAnimation(megaText01_02Anim);

        // TODO megaText2: page 2
        SCViewAnimation megaText02_02Anim = new SCViewAnimation(megaText02);
        megaText02_02Anim.startToAlpha(0f);
        megaText02_02Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interW = new SCLinearInterpolator(900f,400f,0f,0.9f);
            SCLinearInterpolator interH = new SCLinearInterpolator(900f,300f,0f,0.9f);
            SCLinearInterpolator interY = new SCLinearInterpolator(300,300,0f,1f);
            SCLinearInterpolator interSize = new SCLinearInterpolator(36f,18f,0f,1f);

            @Override
            public void applyTransformation(View view, float offset) {
                if(offset<=0.9f) {
                    view.setY(interY.apply(offset));
                    view.getLayoutParams().width = (int) interW.apply(offset);
                    view.getLayoutParams().height = (int) interH.apply(offset);
                    ((TextView)megaText02).setTextSize(TypedValue.COMPLEX_UNIT_SP,interSize.apply(offset));
                }else{
                    view.setY(300);
                    view.getLayoutParams().width = 420;
                    view.getLayoutParams().height= 300;
                    ((TextView)megaText02).setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                }
                view.requestLayout();
            }
        });
        addPagerAnimation(megaText02_02Anim);

        // TODO pictureSend: page 3
        SCViewAnimation pictureSendAnim = new SCViewAnimation(pictureSend);
        pictureSendAnim.startToAlpha(0f);
        pictureSendAnim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(size.x+200, SCUtil.widthQuart(), 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(pictureSendAnim);

        // TODO contact01
        SCViewAnimation contact01Anim = new SCViewAnimation(contact01);
        contact01Anim.startToAlpha(0f);
        contact01Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(-200, 100, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(contact01Anim);

        // TODO contact02
        SCViewAnimation contact02Anim = new SCViewAnimation(contact02);
        contact02Anim.startToAlpha(0f);
        contact02Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(-100, SCUtil.widthHalf(), 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(contact02Anim);

        // TODO contact03
        SCViewAnimation contact03Anim = new SCViewAnimation(contact03);
        contact03Anim.startToAlpha(0f);
        contact03Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(size.x+SCUtil.widthQuart(), size.x-300, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(contact03Anim);

        // TODO contact04
        SCViewAnimation contact04Anim = new SCViewAnimation(contact04);
        contact04Anim.startToAlpha(0f);
        contact04Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(-200, 200, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(contact04Anim);

        // TODO contact05
        SCViewAnimation contact05Anim = new SCViewAnimation(contact05);
        contact05Anim.startToAlpha(0f);
        contact05Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(SCUtil.widthHalf()+size.x, size.x-200, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(contact05Anim);

        // TODO contact06
        SCViewAnimation contact06Anim = new SCViewAnimation(contact06);
        contact06Anim.startToAlpha(0f);
        contact06Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(-500, 200, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(contact06Anim);

        // TODO contact07
        SCViewAnimation contact07Anim = new SCViewAnimation(contact07);
        contact07Anim.startToAlpha(0f);
        contact07Anim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);
            SCLinearInterpolator interX = new SCLinearInterpolator(SCUtil.widthHalf() + size.x, size.x - 200, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.setX(interX.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(contact07Anim);

        // TODO introSend
        SCViewAnimation introSendAnim = new SCViewAnimation(introSend);
        introSendAnim.startToAlpha(0f);
        introSendAnim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
            }
        });
        introSendAnim.addPageAnimation(new SCPageAnimation(PAGE_3) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(1f, 0f, 0f, 0.3f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
            }
        });
        addPagerAnimation(introSendAnim);

        // TODO loginBtn
        SCViewAnimation loginBtnAnim = new SCViewAnimation(loginBtn);
        loginBtnAnim.startToAlpha(0f);
        loginBtn.setClickable(false);
        loginBtn.setText(Html.fromHtml(getString(R.string.joint_tuya)));
        loginBtnAnim.addPageAnimation(new SCPageAnimation(PAGE_2) {
            SCLinearInterpolator interAlpha = new SCLinearInterpolator(0f, 1f, 0.5f, 1f);

            @Override
            public void applyTransformation(View view, float offset) {
                view.setAlpha(interAlpha.apply(offset));
                view.requestLayout();
                if(offset>0.5){
                    loginBtn.setClickable(true);
                }else{
                    loginBtn.setClickable(false);
                }
            }
        });
        addPagerAnimation(loginBtnAnim);

    }

    @Override
    protected int getNumPages() {
        return NUM_PAGES;
    }

    public void startTuyaApp(View v){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("is.cinnamon.koala");
        startActivity(launchIntent);
    }
}
