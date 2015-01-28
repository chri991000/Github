package com.chri99.tavolaperiodica;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    public boolean isProcessed = false;

    public int page = 1;   // 1 main, 0 before, 2 after
    public String[] ans;
    public String inp;
    ViewFlipper viewFlipper;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchBtn = (Button) findViewById(R.id.searchBtn);
        final ImageButton elementBtn = (ImageButton) findViewById(R.id.elementBtn);
        elementBtn.setClickable(false);
        elementBtn.setVisibility(View.INVISIBLE);

        this.viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        buttonHandler();
        ///touch event handling///

        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);

    }

    ///Button event Handling///
    public void buttonHandler() {

        final Button searchBtn = (Button) findViewById(R.id.searchBtn);
        final ImageButton elementBtn = (ImageButton) findViewById(R.id.elementBtn);
        final TextView warning_text = (TextView) findViewById(R.id.warning_text);

        searchBtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        try {
                            EditText nameInput = (EditText) findViewById(R.id.nameInput);

                            elementBtn.setVisibility(View.VISIBLE);
                            elementBtn.setBackgroundColor(Color.TRANSPARENT);

                            inp = FirstUpperCase(nameInput.getText().toString());
                            SearchClass search = new SearchClass();
                            ans = getArray(search.getNAt(inp));
                            warning_text.setText("");
                        } catch (Exception e) {
                            isProcessed = false;
                            elementBtn.setVisibility(View.INVISIBLE);
                            warning_text.setText("!");

                        }
                    }
                }
        );

        elementBtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        setPage2();
                        viewFlipper.showNext();
                        page = 2;
                        isProcessed = true;

                    }
                }
        );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //////Start Gestures /////
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        velocityX = -velocityX;
        int min = 50;
        if (velocityX < -min && page == 1) {
            // Next screen comes in from left.
            viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
            // Current screen goes out from right.
            viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);

            viewFlipper.showPrevious();

            //Button elementBtn = (Button)findViewById(R.id.elementBtn);
            //elementBtn.setVisibility(View.INVISIBLE);
            //elementBtn.setClickable(false);
            page = 0;
            buttonHandler();
            //isProcessed=false;
            return true;
        }
        if (velocityX > min && page == 0) {
            // Next screen comes in from left.
            viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
            // Current screen goes out from right.
            viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);

            viewFlipper.showNext();
            page = 1;
            return true;
        }
        if (isProcessed) {
            if (velocityX < -min && page == 2) {
                // Next screen comes in from left.
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                // Current screen goes out from right.
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);

                viewFlipper.showPrevious();

                //Button elementBtn = (Button)findViewById(R.id.elementBtn);
                //elementBtn.setVisibility(View.INVISIBLE);
                //elementBtn.setClickable(false);
                page = 1;
                buttonHandler();
                //isProcessed=false;
                return true;
            }


            if (velocityX > min && page == 1) {
                // Next screen comes in from left.
                viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                // Current screen goes out from right.
                viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);

                viewFlipper.showNext();
                page = 2;
                return true;
            }
        }
        return true;
    }
    /////end Gestures/////


    ////receiving input and sending them to SearchClass////

    public void setPage2() {

        ImageView display = (ImageView)findViewById(R.id.Result);

        String Inp = FirstUpperCase(inp);

        SearchClass search = new SearchClass();

        // Next screen comes in from left.
        viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
        // Current screen goes out from right.
        viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
        display.setImageResource(search.getId(Integer.parseInt(ans[0])));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String ArraytoString(String[] a) {

        StringBuilder builder = new StringBuilder();
        for (String s : a) {
            builder.append(s);
        }
        return builder.toString();
    }

    public String[] getArray(int i) {
        String[] e = new String[8];
        String[] e2;
        String E = "";
        Resources res = getResources();

        switch (i) {
            case 1:
                String[] tmp = res.getStringArray(R.array.h);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.h2);
                E = "H";
                break;
            case 2:
                tmp = res.getStringArray(R.array.he);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.he2);
                E = "He";
                break;
            case 3:
                tmp = res.getStringArray(R.array.li);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.li2);
                E = "Li";
                break;
            case 4:
                tmp = res.getStringArray(R.array.be);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.be2);
                E = "Be";
                break;
            case 5:
                tmp = res.getStringArray(R.array.b);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.b2);
                E = "B";
                break;
            case 6:
                tmp = res.getStringArray(R.array.c);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.c2);
                E = "C";
                break;
            case 7:
                tmp = res.getStringArray(R.array.n);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.n2);
                E = "N";
                break;
            case 8:
                tmp = res.getStringArray(R.array.o);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.o2);
                E = "O";
                break;
            case 9:
                tmp = res.getStringArray(R.array.f);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.f2);
                E = "F";
                break;
            case 10:
                tmp = res.getStringArray(R.array.ne);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.ne2);
                E = "Ne";
                break;
            case 11:
                tmp = res.getStringArray(R.array.na);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.na2);
                E = "Na";
                break;
            case 12:
                tmp = res.getStringArray(R.array.mg);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.mg2);
                E = "Mg";
                break;
            case 13:
                tmp = res.getStringArray(R.array.al);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.al2);
                E = "Al";
                break;
            case 14:
                tmp = res.getStringArray(R.array.si);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.si2);
                E = "Si";
                break;
            case 15:
                tmp = res.getStringArray(R.array.p);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.p2);
                E = "P";
                break;
            case 16:
                tmp = res.getStringArray(R.array.s);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.s2);
                E = "S";
                break;
            case 17:
                tmp = res.getStringArray(R.array.cl);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.cl2);
                E = "Cl";
                break;
            case 18:
                tmp = res.getStringArray(R.array.ar);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.ar2);
                E = "Ar";
                break;
            case 19:
                tmp = res.getStringArray(R.array.k);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.k2);
                E = "K";
                break;
            case 20:
                tmp = res.getStringArray(R.array.ca);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.ca2);
                E = "Ca";
                break;
            case 21:
                tmp = res.getStringArray(R.array.sc);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.sc2);
                E = "Sc";
                break;
            case 22:
                tmp = res.getStringArray(R.array.ti);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.ti2);
                E = "Ti";
                break;
            case 23:
                tmp = res.getStringArray(R.array.v);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.v2);
                E = "V";
                break;
            case 24:
                tmp = res.getStringArray(R.array.cr);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.cr2);
                E = "Cr";
                break;
            case 25:
                tmp = res.getStringArray(R.array.mn);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.mn2);
                E = "Mn";
                break;
            case 26:
                tmp = res.getStringArray(R.array.fe);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.fe2);
                E = "Fe";
                break;
            case 27:
                tmp = res.getStringArray(R.array.co);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.co2);
                E = "Co";
                break;
            case 28:
                tmp = res.getStringArray(R.array.ni);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.ni2);
                E = "Ni";
                break;
            case 29:
                tmp = res.getStringArray(R.array.cu);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.cu2);
                E = "Cu";
                break;
            case 30:
                tmp = res.getStringArray(R.array.zn);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.zn2);
                E = "Zn";
                break;
            case 31:
                tmp = res.getStringArray(R.array.ga);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.ga2);
                E = "Ga";
                break;
            case 32:
                tmp = res.getStringArray(R.array.ge);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.ge2);
                E = "Ge";
                break;
            case 33:
                tmp = res.getStringArray(R.array.as);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.as2);
                E = "As";
                break;
            case 34:
                tmp = res.getStringArray(R.array.se);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.se2);
                E = "Se";
                break;
            case 35:
                tmp = res.getStringArray(R.array.br);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.br2);
                E = "Br";
                break;
            case 36:
                tmp = res.getStringArray(R.array.kr);
                System.arraycopy(tmp, 0, e, 0, 6);
                e2 = res.getStringArray(R.array.kr2);
                E = "Kr";
                break;
            default:
                e2 = null;
                e = null;
        }

        e[6] = ArraytoString(e2);
        e[7] = E;

        return e;
    }


    public String FirstUpperCase(String s) {
        s.toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}


