package com.hans.wanandroid.net;

import com.hans.wanandroid.model.pojo.BannerBean;
import com.hans.wanandroid.model.pojo.CollectBean;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.DatasBean;
import com.hans.wanandroid.model.pojo.FriendBean;
import com.hans.wanandroid.model.pojo.HotkeyBean;
import com.hans.wanandroid.model.pojo.NaviPrimaryBean;
import com.hans.wanandroid.model.pojo.NaviSecondaryBean;
import com.hans.wanandroid.model.pojo.ProjectBean;
import com.hans.wanandroid.model.pojo.ProjectDetailBean;
import com.hans.wanandroid.model.pojo.TreeBean;
import com.hans.wanandroid.model.pojo.TreeChildrenBean;
import com.hans.wanandroid.model.pojo.TreeDetailBean;
import com.hans.wanandroid.model.pojo.WanBean;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hans
 * date: 2018/2/27 14:33.
 * e-mail: hxxx1992@163.com
 */

public interface WanApi {


    //    参数：页码，拼接在连接中，从0开始。
    @GET("/article/list/{pageIndex}/json")
    Observable<WanBean<DataBean<DatasBean>>> getArticleList(
            @Path("pageIndex") int pageIndex
    );

    @GET("/banner/json")
    Observable<WanBean<List<BannerBean>>> getBannerList(
    );

    @GET("/friend/json")
    Observable<WanBean<List<FriendBean>>> getFriendList(
    );

    @GET("/hotkey/json")
    Observable<WanBean<List<HotkeyBean>>> getHotkeyList(
    );

    @GET("/tree/json")
    Observable<WanBean<List<TreeBean<TreeChildrenBean>>>> getTreeList(
    );

    @GET("/article/list/{pageIndex}/json")
    Observable<WanBean<DataBean<TreeDetailBean>>> getTreeDetailList(
            @Path("pageIndex") int pageIndex,
            @Query("cid") int cid
    );

    @GET("/navi/json")
    Observable<WanBean<List<NaviPrimaryBean<NaviSecondaryBean>>>> getNaviList(
    );

    @GET("/project/tree/json")
    Observable<WanBean<List<ProjectBean>>> getProjectList(
    );

    //    页码：拼接在链接中，从1开始。
    @GET("/project/list/{pageIndex}/json?cid=294")
    Observable<WanBean<DataBean<ProjectDetailBean>>> getProjectDetailList(
            @Path("pageIndex") int pageIndex,
            @Query("cid") int cid
    );


    @POST("/user/login")
    Observable<Object> requestLogin(
            @Query("username") String username,
            @Query("password") String password

    );

    @GET("/lg/collect/list/0/json")
    Observable<WanBean<DataBean<CollectBean>>> requestCollect(

    );
}
