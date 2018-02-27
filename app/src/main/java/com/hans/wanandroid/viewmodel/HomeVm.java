package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.hans.wanandroid.R;
import com.hans.wanandroid.adapter.MvvmCommonAdapter;
import com.hans.wanandroid.databinding.ActivityHomeBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.model.mock.MockUser;
import com.njqg.orchard.library_core.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hans
 * date: 2018/2/27 17:56.
 * e-mail: hxxx1992@163.com
 */

public class HomeVm extends BaseVM<ActivityHomeBinding> {

    private List<MockUser> datas;

    public HomeVm(Context context, ActivityHomeBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        initData();
        MvvmCommonAdapter commonAdapter = new MvvmCommonAdapter(context
                , datas, R.layout.home_list_layout, BR.muvm);
        viewBinding.homeRecy.setAdapter(commonAdapter);
        viewBinding.homeRecy.setLayoutManager(new LinearLayoutManager(context));

    }

    private void initData() {
        datas = new ArrayList<>();
        datas.add(new MockUser("路人甲", 18, true));
        datas.add(new MockUser("苦逼乙", 25, true));
        datas.add(new MockUser("神经丙", 38, true));
        datas.add(new MockUser("目不识丁", 50, true));
    }

    public void show(){
        datas.get(3).setAge(99);
        datas.get(3).setName("hans");
        LogUtils.e(TAG,"age:"+datas.get(3).getAge());
        LogUtils.e(TAG,"name:"+datas.get(3).getName());

    }
}
