package xu.qiwei.com.todomvvmtest.chart;

import java.util.List;

/**
 * Created by xuqiwei on 17-3-16.
 */

public class DrawBean {
    //    图表距离控件左边的高度
    private float marLeft;
    //    柱形图之间的间距
    private float zhuSpace;
    //    柱形图宽度
    private float zhuWidth;
    //    图表距离控件顶部的高度
    private float marTop;
//       图表距离控件右边的距离
    private float marRight;
//    图表距离控件底部的距离
    private float marBtm;
    //    图表内y轴的高度
    private float totalVertical;
    //    图标内x轴的高度
    private float totalHorizal;

//    图表y轴要显示的文字
    private List<String> yTextList;
//    图表x轴需要显示的数据
    private List<StatisData> xDataList;
//    图表y轴的总分
    private int totalScore;

    public DrawBean(List<String> yTextList, List<StatisData> xDataList, float marLeft, float marTop,float marBtm,int marRight,int totalScore) {
        this.yTextList = yTextList;
        this.xDataList = xDataList;
        this.marLeft = marLeft;
        this.marTop = marTop;
        this.marBtm = marBtm;
        this.marRight = marRight;
        this.totalScore = totalScore;
    }

    public float getMarRight() {
        return marRight;
    }

    public void setMarRight(float marRight) {
        this.marRight = marRight;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public List<String> getyTextList() {
        return yTextList;
    }

    public void setyTextList(List<String> yTextList) {
        this.yTextList = yTextList;
    }

    public List<StatisData> getxDataList() {
        return xDataList;
    }

    public void setxDataList(List<StatisData> xDataList) {
        this.xDataList = xDataList;
    }

    public float getMarBtm() {
        return marBtm;
    }

    public void setMarBtm(float marBtm) {
        this.marBtm = marBtm;
    }

    public float getMarLeft() {
        return marLeft;
    }

    public void setMarLeft(float marLeft) {
        this.marLeft = marLeft;
    }

    public float getZhuSpace() {
        return zhuSpace;
    }

    public void setZhuSpace(float zhuSpace) {
        this.zhuSpace = zhuSpace;
    }

    public float getZhuWidth() {
        return zhuWidth;
    }

    public void setZhuWidth(float zhuWidth) {
        this.zhuWidth = zhuWidth;
    }

    public float getMarTop() {
        return marTop;
    }

    public void setMarTop(float marTop) {
        this.marTop = marTop;
    }

    public float getTotalVertical() {
        return totalVertical;
    }

    public void setTotalVertical(float totalVertical) {
        this.totalVertical = totalVertical;
    }

    public float getTotalHorizal() {
        return totalHorizal;
    }

    public void setTotalHorizal(float totalHorizal) {
        this.totalHorizal = totalHorizal;
    }
}
