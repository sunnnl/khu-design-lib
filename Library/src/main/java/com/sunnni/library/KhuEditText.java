package com.sunnni.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class KhuEditText extends ConstraintLayout {
    ConstraintLayout bg;
    ImageView icon;
    EditText edt;

    public KhuEditText(Context ctx){
        super(ctx);
        init();
    }

    public KhuEditText(Context ctx, AttributeSet attrs){
        super(ctx, attrs);
        init();
        getAttrs(attrs);
    }

    public KhuEditText(Context ctx, AttributeSet attrs, int defStyle){
        super(ctx, attrs);
        init();
        getAttrs(attrs, defStyle);
    }

    private void init(){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.khu_edit_text, this, false);
        addView(v);

        bg = (ConstraintLayout) findViewById(R.id.edt_bg);
        icon = (ImageView) findViewById(R.id.edt_ic);
        edt = (EditText) findViewById(R.id.edt);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.KhuEditText);
        setTypedArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.KhuEditText, defStyle, 0);
        setTypedArray(typedArray);
    }

    private void setTypedArray(TypedArray typedArray) {

        String hint_string = typedArray.getString(R.styleable.KhuEditText_hint);
        edt.setHint(hint_string);

        int symbol_resID = typedArray.getResourceId(R.styleable.KhuEditText_setIcon, -1);
        if (symbol_resID == -1) {
            icon.setVisibility(View.GONE);
        } else {
            icon.setImageResource(symbol_resID);
        }

        typedArray.recycle();
    }

    public String getText(){
        return edt.getText().toString();
    }
}
