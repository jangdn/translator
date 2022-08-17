package model.view;

import model.process.Paragraph;

import java.util.Optional;

public interface ViewPattern {
    String getPrevious(Optional<Paragraph> viewPattern);
    String getNext(Optional<Paragraph> viewPattern);
}
