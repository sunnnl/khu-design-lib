package com.sunnni.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import static com.sunnni.library.Code.BTN_TYPE_BLUE;
import static com.sunnni.library.Code.BTN_TYPE_GREY;
import static com.sunnni.library.Code.BTN_TYPE_RED;


public class KhuButton extends ConstraintLayout {

    ConstraintLayout bg;
    TextView txt;

    public KhuButton(Context ctx) {
        super(ctx);
        init();
    }
    public KhuButton(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        init();
        getAttrs(attrs);
    }
    public KhuButton(Context ctx, AttributeSet attrs, int defStyle) {
        super(ctx, attrs);
        init();
        getAttrs(attrs, defStyle);
    }

    private void init() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.khu_button, this, false);
        addView(v);

        bg = (ConstraintLayout) findViewById(R.id.btn_bg);
        txt = (TextView) findViewById(R.id.btn_tv);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.KhuButton);
        setTypedArray(typedArray);
    }
    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.KhuButton, defStyle, 0);
        setTypedArray(typedArray);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setTypedArray(TypedArray typedArray) {

        String text_string = typedArray.getString(R.styleable.KhuButton_text);
        txt.setText(text_string);

        String btn_type = typedArray.getString(R.styleable.KhuButton_type);
        if (BTN_TYPE_RED.equals(btn_type)) {
            bg.setBackground(getResources().getDrawable(R.drawable.bg_btn_red, null));
        } else if(BTN_TYPE_BLUE.equals(btn_type)) {
            bg.setBackground(getResources().getDrawable(R.drawable.bg_btn_blue, null));
        } else if(BTN_TYPE_GREY.equals(btn_type)) {
            bg.setBackground(getResources().getDrawable(R.drawable.bg_btn_grey, null));
        }

        typedArray.recycle();
    }

    void setBg(int bg_resID) { bg.setBackgroundResource(bg_resID); }
    void setText(String text_string) { txt.setText(text_string); }
    void setText(int text_resID) { txt.setText(text_resID); }
    void setTextColor(int color) { txt.setTextColor(color); }
}
