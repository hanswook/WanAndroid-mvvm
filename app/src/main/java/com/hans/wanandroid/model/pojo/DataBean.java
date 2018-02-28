package com.hans.wanandroid.model.pojo;

import java.util.List;

/**
 * Created by hans
 * date: 2018/2/27 14:37.
 * e-mail: hxxx1992@163.com
 */

public class DataBean<T> {
    /**
     * curPage : 2
     * datas : [{"apkLink":"","author":"张洋","chapterId":303,"chapterName":"区块链","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2331,"link":"http://blog.codinglabs.org/articles/bitcoin-mechanism-make-easy.html","niceDate":"2018-02-09","origin":"","projectLink":"","publishTime":1518169644000,"title":"一个故事告诉你比特币的原理及运作机制","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":292,"chapterName":"pdf电子书","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2329,"link":"http://www.wanandroid.com/blog/show/2041","niceDate":"2018-02-08","origin":"","projectLink":"","publishTime":1518093100000,"title":"美团点评技术年货 pdf下载","visible":1,"zan":0},{"apkLink":"","author":"ZedeChan","chapterId":308,"chapterName":"多线程","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2326,"link":"https://juejin.im/post/5a771e6d6fb9a0634c264870","niceDate":"2018-02-08","origin":"","projectLink":"","publishTime":1518070796000,"title":"多线程详解（2）\u2014\u2014不得不知的几个概念","visible":1,"zan":0},{"apkLink":"","author":"ZedeChan","chapterId":308,"chapterName":"多线程","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2325,"link":"https://juejin.im/post/5a6dc8e45188257326470c55","niceDate":"2018-02-08","origin":"","projectLink":"","publishTime":1518070781000,"title":"多线程详解（1）\u2014\u2014线程基本概念","visible":1,"zan":0},{"apkLink":"","author":"dbzhang800","chapterId":182,"chapterName":"JNI编程","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2324,"link":"http://blog.csdn.net/dbzhang800/article/details/6314073","niceDate":"2018-02-07","origin":"","projectLink":"","publishTime":1517994296000,"title":"cmake 学习笔记(一)","visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":298,"chapterName":"我的博客","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2323,"link":"http://www.wanandroid.com/blog/show/2038","niceDate":"2018-02-07","origin":"","projectLink":"","publishTime":1517969831000,"title":"从一道面试题开始说起 枚举、动态代理的原理","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":274,"chapterName":"个人博客","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2321,"link":"https://www.jianshu.com/u/383970bef0a0","niceDate":"2018-02-06","origin":"","projectLink":"","publishTime":1517884084000,"title":"Carson_Ho","visible":1,"zan":0},{"apkLink":"","author":"crazysunj","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2320,"link":"https://juejin.im/post/5a7783b65188257a6d635a8b","niceDate":"2018-02-05","origin":"","projectLink":"","publishTime":1517841387000,"title":"揭开Java内存管理的面纱","visible":1,"zan":0},{"apkLink":"","author":"Andreas M Antonopoulos","chapterId":303,"chapterName":"区块链","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2319,"link":"http://zhibimo.com/read/wang-miao/mastering-bitcoin/index.html","niceDate":"2018-02-05","origin":"","projectLink":"","publishTime":1517822567000,"title":"精通比特币","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":305,"chapterName":"各类工具","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2318,"link":"http://www.wanandroid.com/blog/show/2037","niceDate":"2018-02-05","origin":"","projectLink":"","publishTime":1517800719000,"title":"区块链养狗领取","visible":1,"zan":0},{"apkLink":"","author":"七叶林","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2255,"link":"http://blog.csdn.net/handsonn/article/details/78997512","niceDate":"2018-02-04","origin":"","projectLink":"","publishTime":1517711218000,"title":"Android搜索中前缀匹配的一点理解","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":292,"chapterName":"pdf电子书","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2254,"link":"http://www.wanandroid.com/blog/show/2036","niceDate":"2018-02-02","origin":"","projectLink":"","publishTime":1517562829000,"title":"[PDF] Cmake实践下载","visible":1,"zan":0},{"apkLink":"","author":"cfanr","chapterId":182,"chapterName":"JNI编程","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2253,"link":"http://cfanr.cn/2017/08/26/Android-NDK-dev-CMake-s-usage/","niceDate":"2018-02-02","origin":"","projectLink":"","publishTime":1517561475000,"title":"Android NDK 开发：CMake 使用","visible":1,"zan":0},{"apkLink":"","author":" 艾米1","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2248,"link":"https://juejin.im/post/5a631efd6fb9a01ca8720f80","niceDate":"2018-02-02","origin":"","projectLink":"","publishTime":1517534417000,"title":"纵享丝滑滑动切换的周月日历，水滴效果，可高度定制，仿小米日历","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":292,"chapterName":"pdf电子书","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2247,"link":"http://www.wanandroid.com/blog/show/2035","niceDate":"2018-02-01","origin":"","projectLink":"","publishTime":1517448292000,"title":"Qcon领略Kotlin的力量 张涛 pdf","visible":1,"zan":0},{"apkLink":"","author":"恋猫月亮","chapterId":97,"chapterName":"音视频","collect":false,"courseId":13,"desc":"","envelopePic":"","id":1630,"link":"http://www.jianshu.com/p/bb5876f34902","niceDate":"2018-01-31","origin":"","projectLink":"","publishTime":1517407935000,"title":"Android 列表视频的全屏、自动小窗口优化实践","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":247,"chapterName":"防逆向","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2246,"link":"https://chaman.gitbooks.io/techblog/Android/apk-enchance/apk-enchance.html","niceDate":"2018-01-30","origin":"","projectLink":"","publishTime":1517302918000,"title":"Android APK加固技术初探","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":305,"chapterName":"各类工具","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2245,"link":"http://www.wanandroid.com/blog/show/2034","niceDate":"2018-01-30","origin":"","projectLink":"","publishTime":1517297965000,"title":"工具分享 ：Jadx 反编译神器","visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":274,"chapterName":"个人博客","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2243,"link":"http://blog.csdn.net/qq_17250009/","niceDate":"2018-01-30","origin":"","projectLink":"","publishTime":1517279352000,"title":"一口仨馍","visible":1,"zan":0},{"apkLink":"","author":"LowCoder","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","id":2242,"link":"http://blog.csdn.net/sdfsdfdfa/article/details/79120665","niceDate":"2018-01-30","origin":"","projectLink":"","publishTime":1517277762000,"title":"Android拼图滑块验证码控件","visible":1,"zan":0}]
     * offset : 20
     * over : false
     * pageCount : 54
     * size : 20
     * total : 1067
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<T> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }


}