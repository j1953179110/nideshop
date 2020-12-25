package com.example.nideshop.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    protected P presenter;
    protected Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(container.getContext()).inflate(getLayout(), null);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        presenter = createPresenter();
        if (presenter != null) {
            presenter.AttchView(this);
        }
        initView(view);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract P createPresenter();

    protected abstract int getLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.DeAttchView();
        }
    }
}
