package model.view;

import static model.ViewModelEnum.NEW_LINE;

public interface Chapter extends ViewPattern {
    @Override
    default String getPrevious() {
        return NEW_LINE + NEW_LINE;
    }

    @Override
    default String getNext() {
        return NEW_LINE;
    }
}
