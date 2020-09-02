package testframe.core.modules;

import org.junit.Assert;

public class LoggerConsole extends LoggerPrototype {
    private String prefix;

    public LoggerConsole() {
        super();
        this.prefix = "";
    }

    @Override
    public void startFolder(String folderName) {
        this.prefix += "---";
        writeMessage(folderName);
    }

    @Override
    public void closeFolder() {
        if (prefix.length() <= 0) {
            this.prefix = "";
        } else {
            this.prefix = prefix.substring(0, prefix.length() - 3);
        }
    }

    @Override
    public void logMessage(String message) {
        writeMessage(message);
    }

    @Override
    public void logDebugMessage(String message) {
        if (isShowDebug) {
            writeMessage("---" + message);
        }
    }

    @Override
    public void logWarningMessage(String message) {
        writeMessage("!" + message + "!");
    }

    @Override
    public void logErrorMessage(String message) {
        writeMessage("!!!" + message + "!!!");
        if (isErrorFail) {
            Assert.fail(message);
        }
    }

    @Override
    public void logCriticalError(String message) {
        writeMessage(">>>!!!" + message + "!!!<<<");
        Assert.fail(message);
    }

    @Override
    public void logCriticalError(String message, Exception e) {
        writeMessage(">>>!!!" + message + "!!!<<<");
        Assert.fail(message);
    }

    @Override
    public void startCheck(String testName) {
        //throw new NotImplementedException();
    }

    @Override
    public void finishCheck() {
        //throw new NotImplementedException();
    }

    @Override
    public void getReport() {
        //throw new NotImplementedException();
    }

    @Override
    public void startTest(String testName) {
        writeMessage("-Начало теста -" + testName + "-");
        startTest();
    }

    @Override
    public void finishTest() {
        writeMessage("-");
    }

    /*@Override
    public void startCheck(String testName) {
        writeMessage("-Начало проверки -" + testName + "-");
        this.errorCheck = ErrorType.NONE;
    }

    //@Override
    public void finishCheck() {
        writeMessage("-Завершение проверки-");
    }*/

    private void writeMessage(String message) {
        System.out.println(prefix + message);
    }
}
