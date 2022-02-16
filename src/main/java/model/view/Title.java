package model.view;

import static model.ViewModelEnum.NEW_LINE;

public interface Title extends ViewPattern {
    @Override
    default String getPrevious() {
        return "";
    }

    @Override
    default String getNext() {
        return NEW_LINE + NEW_LINE + NEW_LINE;
    }
}
