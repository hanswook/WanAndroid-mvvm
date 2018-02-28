package com.hans.wanandroid.model.model;

import android.view.View;
import android.widget.Toast;

import com.hans.wanandroid.model.pojo.DatasBean;
import com.njqg.orchard.library_core.utils.LogUtils;

/**
 * Created by hans
 * date: 2018/2/28 12:28.
 * e-mail: hxxx1992@163.com
 */

public class HomeListModel {

    private String title;
    private String desc;
    private DatasBean datasBean;

    public DatasBean getDatasBean() {
        return datasBean;
    }

    public void setDatasBean(DatasBean datasBean) {
        this.datasBean = datasBean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void getOnItemListener(View view) {
        Toast.makeText(view.getContext(), "点击了"+title, Toast.LENGTH_SHORT).show();

    }

    public void showBtn1(){
        LogUtils.e("hlm","show btn 1");
    }
    public void showBtn2(){
        LogUtils.e("hlm","show btn 2");
    }




}
