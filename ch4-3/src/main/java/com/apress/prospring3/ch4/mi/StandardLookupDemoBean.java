package com.apress.prospring3.ch4.mi;

public class StandardLookupDemoBean implements DemoBean {

    private MyHelper myHelper;

    public MyHelper getMyHelper() {
        return myHelper;
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    public void someOperation() {
        myHelper.doSomethingHelpful();
    }

}
