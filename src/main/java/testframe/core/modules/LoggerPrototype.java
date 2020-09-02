package testframe.core.modules;

import java.util.List;

public abstract class LoggerPrototype {
    protected boolean isShowDebug;
    //~~~List<Check> checkList;
    protected int warningCount;
    protected int errorCount;
    protected int criticalCount;//~~~???
    protected int currentWarningCount;
    protected int currentErrorCount;
    protected boolean isErrorFail;

    public LoggerPrototype() {
        isShowDebug = false;
        warningCount = 0;
        errorCount = 0;
        criticalCount = 0;
        isErrorFail = false;
    }

    public void enableDebugMessages() {
        isShowDebug = true;
    }

    public void disableDebugMessages() {
        isShowDebug = false;
    }

    public abstract void startFolder(String folderName);
    public abstract void closeFolder();

    public abstract void startTest(String testName);
    protected void startTest() {
        warningCount = 0;
        errorCount = 0;
        criticalCount = 0;
    }
    public abstract void finishTest();

    public abstract void logMessage(String message);
    public abstract void logDebugMessage(String message);
    public void logWarningMessage(String message) {
        warningCount++;
    }
    public void logErrorMessage(String message) {
        errorCount++;
    }
    public abstract void logCriticalError(String message);
    public abstract void logCriticalError(String message, Exception e);

//    public void logAssert(String message);
//    public void logAssertEquals(int etalon, int compare, String message);
//    public void logAssertEquals(String etalon, String compare, String message);

    public abstract void startCheck(String testName);
    public abstract void finishCheck();
    public abstract void getReport();
    //public ChecksSummary getChecksResult();
}
