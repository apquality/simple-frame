package pages;

import testframe.core.helpers.CoreAcolyteHelper;
import testframe.core.modules.LoggerPrototype;

public abstract class PagePrototype {
    protected CoreAcolyteHelper coreData;
    protected LoggerPrototype logger;

    public PagePrototype(CoreAcolyteHelper coreData) {
        this.coreData = coreData;
        this.logger = coreData.logger;
    }
}
