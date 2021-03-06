package model.view;

import static model.ViewModelEnum.NEW_LINE;

public interface Outline extends ViewPattern {
    @Override
    default String getPrevious() {
        return NEW_LINE;
    };

    @Override
    default String getNext() {
        return NEW_LINE;
    }
}
