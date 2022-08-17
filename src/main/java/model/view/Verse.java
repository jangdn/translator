package model.view;

import model.process.Paragraph;

import java.util.Optional;

import static model.ViewModelEnum.NEW_LINE;

public interface Verse extends ViewPattern {
    @Override
    default String getPrevious(Optional<Paragraph> viewPattern) {
        return "";
    }

    @Override
    default String getNext(Optional<Paragraph> viewPattern) {
        return NEW_LINE;
    }
}
