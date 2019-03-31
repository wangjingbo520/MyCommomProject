package com.eims.app.common.widgets.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.eims.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author bobo
 * @date 2018/10/15
 * describe
 */
public class CustomDialog extends AlertDialog {
    private onClickListener listener;

    @BindView(R.id.tv_content)
    TextView mContent;
    @BindView(R.id.tv_title)
    TextView mTitle;
    String title;
    String content;

    public void setListener(onClickListener listener) {
        this.listener = listener;
    }

    public CustomDialog(Context context, String title, String content) {
        this(context, R.style.MyDialog);
        this.title = title;
        this.content = content;
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 预先设置Dialog的一些属性
        setContentView(R.layout.dialog_default);
        ButterKnife.bind(this);
        mTitle.setText(title);
        mContent.setText(content);
    }

    @OnClick(R.id.tv_cancel)
    public void clickCancel() {
        if (listener != null) {
            listener.OnClickCancel();
        }
    }

    @OnClick(R.id.tv_confirm)
    public void clickConfirm() {
        if (listener != null) {
            listener.OnClickConfirm();
        }
    }

    public interface onClickListener {
        void OnClickConfirm();

        void OnClickCancel();
    }
}

