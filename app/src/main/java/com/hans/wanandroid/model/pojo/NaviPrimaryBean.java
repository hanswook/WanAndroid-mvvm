package com.hans.wanandroid.model.pojo;

import java.util.List;

/**
 * Created by hans
 * date: 2018/2/27 15:53.
 * e-mail: hxxx1992@163.com
 */

public class NaviPrimaryBean<T> {

    /**
     * articles : [{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1848,"link":"https://developers.google.cn/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515322795000,"title":"Google开发者","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1849,"link":"http://www.github.com/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515322817000,"title":"Github","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1850,"link":"https://stackoverflow.com/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515322829000,"title":"stackoverflow","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1851,"link":"https://juejin.im/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323408000,"title":"掘金","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1852,"link":"https://www.csdn.net/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323423000,"title":"CSDN","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1853,"link":"https://www.jianshu.com/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323438000,"title":"简书","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1854,"link":"http://www.androidweekly.cn/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323568000,"title":"开发技术周报","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1855,"link":"https://toutiao.io/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323607000,"title":"开发者头条","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1856,"link":"https://segmentfault.com/t/android","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323635000,"title":"segmentfault","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1857,"link":"http://www.androiddevtools.cn/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323651000,"title":"androiddevtools","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1858,"link":"https://developers.googleblog.cn/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323695000,"title":"Google中文Blog","visible":0,"zan":0},{"apkLink":"","author":"gank.io","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1859,"link":"http://gank.io/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515323720000,"title":"干货集中营","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1862,"link":"http://a.codekk.com/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515324437000,"title":"CodeKK","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1863,"link":"https://xiaozhuanlan.com/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515324456000,"title":"小专栏","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1864,"link":"http://www.wanandroid.com/article/list/0?cid=176","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515324541000,"title":"国内大牛","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1865,"link":"https://github.com/android-cn/android-dev-com","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515324559000,"title":"国外大牛","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1866,"link":"https://www.androidos.net.cn/sourcecode","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515324594000,"title":"Android源码","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1867,"link":"http://design.1sters.com/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515324880000,"title":"Material Design 中文版","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1868,"link":"https://leetcode.com/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515325010000,"title":"leetcode","visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2405,"link":"https://dl.google.com/dl/android/maven2/index.html","niceDate":"1天前","origin":"","projectLink":"","publishTime":1519537704000,"title":"google mvn仓库","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2406,"link":"http://jcenter.bintray.com/","niceDate":"1天前","origin":"","projectLink":"","publishTime":1519537722000,"title":"jcenter仓库","visible":1,"zan":0}]
     * cid : 272
     * name : 常用网站
     */

    private int cid;
    private String name;
    private List<T> articles;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getArticles() {
        return articles;
    }

    public void setArticles(List<T> articles) {
        this.articles = articles;
    }


}
