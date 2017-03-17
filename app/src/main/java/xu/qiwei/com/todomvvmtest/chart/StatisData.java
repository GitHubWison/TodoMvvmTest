package xu.qiwei.com.todomvvmtest.chart;

/**
 * Created by xuqiwei on 17-3-17.
 */

public class StatisData {
    private int fillData;
    private int innerData;
    private String dataName;

    public StatisData() {

    }

    public StatisData(int fillData, int innerData, String dataName) {
        this.fillData = fillData;
        this.innerData = innerData;
        this.dataName = dataName;
    }

    public int getFillData() {
        return fillData;
    }

    public void setFillData(int fillData) {
        this.fillData = fillData;
    }

    public int getInnerData() {
        return innerData;
    }

    public void setInnerData(int innerData) {
        this.innerData = innerData;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
}
