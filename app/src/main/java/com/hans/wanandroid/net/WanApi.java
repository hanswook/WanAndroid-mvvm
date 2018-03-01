package com.hans.wanandroid.net;

import com.hans.wanandroid.model.pojo.ArticleBean;
import com.hans.wanandroid.model.pojo.BannerBean;
import com.hans.wanandroid.model.pojo.CollectBean;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.FriendBean;
import com.hans.wanandroid.model.pojo.HotkeyBean;
import com.hans.wanandroid.model.pojo.NaviPrimaryBean;
import com.hans.wanandroid.model.pojo.ProjectBean;
import com.hans.wanandroid.model.pojo.ResponseData;
import com.hans.wanandroid.model.pojo.TreeBean;


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
    Observable<ResponseData<DataBean<ArticleBean>>> getArticleList(
            @Path("pageIndex") int pageIndex
    );

    @GET("/banner/json")
    Observable<ResponseData<List<BannerBean>>> getBannerList(
    );

    @GET("/friend/json")
    Observable<ResponseData<List<FriendBean>>> getFriendList(
    );

    @GET("/hotkey/json")
    Observable<ResponseData<List<HotkeyBean>>> getHotkeyList(
    );

    @GET("/tree/json")
    Observable<ResponseData<List<TreeBean<TreeBean>>>> getTreeList(
    );

    @GET("/article/list/{pageIndex}/json")
    Observable<ResponseData<DataBean<ArticleBean>>> getTreeDetailList(
            @Path("pageIndex") int pageIndex,
            @Query("cid") int cid
    );

    @GET("/navi/json")
    Observable<ResponseData<List<NaviPrimaryBean<ArticleBean>>>> getNaviList(
    );

    @GET("/project/tree/json")
    Observable<ResponseData<List<ProjectBean>>> getProjectList(
    );

    //    页码：拼接在链接中，从1开始。
    @GET("/project/list/{pageIndex}/json?cid=294")
    Observable<ResponseData<DataBean<ArticleBean>>> getProjectDetailList(
            @Path("pageIndex") int pageIndex,
            @Query("cid") int cid
    );


    @POST("/user/login")
    Observable<Object> requestLogin(
            @Query("username") String username,
            @Query("password") String password

    );

    @GET("/lg/collect/list/0/json")
    Observable<ResponseData<DataBean<CollectBean>>> requestCollect(

    );
}
