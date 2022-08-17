package model.view;

import model.process.Paragraph;
import model.process.VerseParagraph;

import java.util.Optional;

import static model.ViewModelEnum.NEW_LINE;

public interface Summary extends ViewPattern {
    @Override
    default String getPrevious(Optional<Paragraph> viewParagraph) {
        if (viewParagraph.isPresent()) {
            if (viewParagraph.get() instanceof VerseParagraph) {
                return NEW_LINE;
            }
        }
        return "";
    }

    @Override
    default String getNext(Optional<Paragraph> viewPattern) {
        return NEW_LINE;
    }
}
