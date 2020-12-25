package com.example.nideshop.base;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {
    public V iView;
    public M iModel;

    public void AttchView(V v) {
        iView = v;
        iModel = getModel();
    }

    public void DeAttchView() {
        iView = null;
        iModel = null;
    }

    protected abstract M getModel();
}
