package com.example.nideshop.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (presenter == null) {
            presenter = createPresenter();
            presenter.AttchView(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.DeAttchView();
        }
    }
}
