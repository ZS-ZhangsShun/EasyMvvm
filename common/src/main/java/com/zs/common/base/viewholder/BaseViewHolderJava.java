package com.zs.common.base.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zs.common.base.viewmodel.BaseViewModel;
import com.zs.common.base.view.IBaseCustomView;

public class BaseViewHolderJava extends RecyclerView.ViewHolder {
    private IBaseCustomView view;

    public BaseViewHolderJava(@NonNull IBaseCustomView view) {
        super((View) view);
        this.view = view;
    }

    public void bindData(BaseViewModel viewModel) {
        view.setData(viewModel);
    }
}
