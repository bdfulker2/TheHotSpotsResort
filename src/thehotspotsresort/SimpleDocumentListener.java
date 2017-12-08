/**
 * This is a functional interface. It is used for all my document listeners
 * on for any of the Textboxes on GuestInfoGUI, LoginGUI
 * 
 */
package thehotspotsresort;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
@FunctionalInterface
public interface SimpleDocumentListener extends DocumentListener {
    void update(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    default void removeUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    default void changedUpdate(DocumentEvent e) {
        update(e);
    }
}
