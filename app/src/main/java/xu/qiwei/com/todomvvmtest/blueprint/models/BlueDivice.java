package xu.qiwei.com.todomvvmtest.blueprint.models;

/**
 * Created by xuqiwei on 17-4-26.
 */

public class BlueDivice {
    private String diviceName;
    private String diviceAddress;
    private boolean isBind;

    public BlueDivice(String diviceName, String diviceAddress,boolean isBind) {
        this.diviceName = diviceName;
        this.diviceAddress = diviceAddress;
        this.isBind = isBind;
    }

    public String getDiviceName() {
        return diviceName;
    }

    public void setDiviceName(String diviceName) {
        this.diviceName = diviceName;
    }

    public String getDiviceAddress() {
        return diviceAddress;
    }

    public void setDiviceAddress(String diviceAddress) {
        this.diviceAddress = diviceAddress;
    }

    public boolean isBind() {
        return isBind;
    }

    public void setBind(boolean bind) {
        isBind = bind;
    }
}
