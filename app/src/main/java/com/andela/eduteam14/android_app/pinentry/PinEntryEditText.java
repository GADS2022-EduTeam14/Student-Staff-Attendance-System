package com.andela.eduteam14.android_app.pinentry;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.andela.eduteam14.android_app.R;

@SuppressLint("AppCompatCustomView")
public class PinEntryEditText extends EditText {

    private float mSpace = 24;
    private float mCharSize = 0;
    private float mNumChars = 5;

    private float mMaxLength = 0;
    private float mLineSpacing = 8;

    private float mLineStroke = 2;
    private Paint mLinesPaint;

    int[][] mStates = new int[][]{
            new int[]{android.R.attr.state_selected},
            new int[]{android.R.attr.state_focused},
            new int[]{-android.R.attr.state_focused},
    };


    int[] mColors = new int[3];

    ColorStateList mColorStates = new ColorStateList(mStates, mColors);


    private OnClickListener mClickListener;

    public String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";

    public PinEntryEditText(Context context) {
        super(context);
    }

    public PinEntryEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PinEntryEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public PinEntryEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setBackgroundResource(0);

        float pixels =
                context.getResources().getDisplayMetrics().density;

        mLineStroke = pixels * mLineStroke;

        mLinesPaint = new Paint(getPaint());

        mLinesPaint.setStrokeWidth(mLineStroke);

        mSpace = mSpace * pixels;

        mLineSpacing = pixels * mLineSpacing;

        mMaxLength = attrs.getAttributeIntValue(
                XML_NAMESPACE_ANDROID, "maxLength", 5
        );

        mNumChars = mMaxLength;

        TypedValue outValue = new TypedValue();

        context.getTheme().resolveAttribute(
                androidx.appcompat.R.attr.colorControlActivated,
                outValue,
                true
        );

        int colorActivated = outValue.data;

        context.getTheme().resolveAttribute(
                androidx.appcompat.R.attr.colorPrimary,
                outValue,
                true
        );

        int colorPrimary = outValue.data;

        context.getTheme().resolveAttribute(
                androidx.appcompat.R.attr.colorControlHighlight,
                outValue,
                true
        );

        int colorHighlight = outValue.data;

        mColors[0] = colorActivated;
        mColors[1] = colorPrimary;
        mColors[2] = colorHighlight;


        //disable copy and paste
        super.setCustomSelectionActionModeCallback(
                new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        return false;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {

                    }
                }
        );

        //when tapped, move cursor to end of the text
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelection(getText().length());
                if (mClickListener != null) {
                    mClickListener.onClick(v);
                }
            }
        });

    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        mClickListener = l;
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        throw new RuntimeException(
                "setCustomSelectionActionModeCallback() not supported."
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        int availableWidth =
                getWidth() - getPaddingRight() - getPaddingLeft();

        if (mSpace < 0) {
            mCharSize = (availableWidth / (mNumChars * 2 - 1));
        } else {
            mCharSize =
                    (availableWidth - (mSpace * (mNumChars - 1))) / mNumChars;
        }

        int startX = getPaddingLeft();
        int bottom = getHeight() - getPaddingBottom();

        Editable text = getText();
        int textLength = text.length();

        float[] textWidths = new float[textLength];

        getPaint().getTextWidths(getText(), 0, textLength, textWidths);

        for (int i = 0; i < mNumChars; i++) {
            updateColorForLines(i == textLength);
            canvas.drawLine(
                    startX,
                    bottom,
                    startX + mCharSize,
                    bottom,
                    mLinesPaint
            );

            if (getText().length() > i) {
                float middle = startX + mCharSize / 2;

                canvas.drawText(
                        text,
                        i,
                        i + 1,
                        middle - textWidths[0] / 2,
                        bottom - mLineSpacing,
                        getPaint()
                );
            }

            if (mSpace < 0) {
                startX += mCharSize * 2;
            } else {
                startX += mCharSize + mSpace;
            }


        }

    }

    private int getColorForState(int... states) {
        return mColorStates.getColorForState(states, Color.GRAY);
    }

    private void updateColorForLines(boolean next) {
        if (isFocused()) {
            mLinesPaint.setColor(
                    getColorForState(android.R.attr.state_focused)
            );
        }

        if (next) {
            mLinesPaint.setColor(
                    getColorForState(android.R.attr.state_selected)
            );
        } else {
            mLinesPaint.setColor(
                    getColorForState(-android.R.attr.state_focused)
            );
        }
    }
}
