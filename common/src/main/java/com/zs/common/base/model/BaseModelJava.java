package com.zs.common.base.model;

import com.zs.easy.common.http.retrofit.ExceptionHandle;

import java.lang.ref.WeakReference;
import java.util.List;

public abstract class BaseModelJava<RETURN_DATA> {
    protected WeakReference<IBaseModelCallback> callbackWeakReference;
    protected int page = 1;
    protected boolean isNeedPage = false;
    protected boolean isLoading = false;
    protected final int PAGE_INIT_NUM;

    protected BaseModelJava(boolean isNeedPage, int... PAGE_INIT_NUM) {
        this.isNeedPage = isNeedPage;
        if (PAGE_INIT_NUM != null && PAGE_INIT_NUM.length > 0) {
            this.PAGE_INIT_NUM = PAGE_INIT_NUM[0];
        } else {
            this.PAGE_INIT_NUM = 0;
        }

    }

    public void registerCallback(IBaseModelCallback callback) {
        callbackWeakReference = new WeakReference<>(callback);
    }

    public void load() {
        if (!isLoading) {
            if (isNeedPage) {
                page = PAGE_INIT_NUM;
            }
            isLoading = true;
            requestData();
        }
    }

    public void loadNextPageData() {
        if (!isLoading) {
            isLoading = true;
            requestData();
        }
    }

    protected abstract void requestData();

    protected void notifySuccessWithData(RETURN_DATA data) {
        isLoading = false;
        IBaseModelCallback iBaseModelCallback = callbackWeakReference.get();
        if (iBaseModelCallback != null) {
            if (isNeedPage) {
                boolean isFirstPage = page == PAGE_INIT_NUM;
                boolean isLastPage = false;
                boolean isEmpty = false;
                if (data == null) {
                    isLastPage = true;
                } else if (data instanceof List) {
                    if (((List) data).isEmpty()) {
                        isLastPage = true;
                        isEmpty = true;
                    }
                }
                iBaseModelCallback.onLoadSuccess(this, data, new PagingResult(isFirstPage, isLastPage, isEmpty));
                if (!isLastPage) {
                    page++;
                }
            } else {
                iBaseModelCallback.onLoadSuccess(this, data);
            }
        }
    }

    protected void notifyErrorWithMsg(ExceptionHandle.ResponseThrowable e) {
        isLoading = false;
        IBaseModelCallback iBaseModelCallback = callbackWeakReference.get();
        if (iBaseModelCallback != null) {
            if (isNeedPage) {
                boolean isFirstPage = page == PAGE_INIT_NUM;
                iBaseModelCallback.onLoadError(this, e, e.message, new PagingResult(isFirstPage, true, true));
            } else {
                iBaseModelCallback.onLoadError(this, e, e.message);
            }
        }
    }
}
