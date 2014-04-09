package org.lotus;

import java.awt.Frame;
import java.awt.EventQueue;
import java.awt.Checkbox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Launch {

    public static void main(String[] args) {
		// create thread for this work(optional but recommended)
		EventQueue.invokeLater(new UiBuilder());
    }
}

class UiBuilder implements Runnable {

    @Override
    public void run() {
        Frame f = new Frame("My AWT Frame"); //set title
        Checkbox c = new Checkbox("Hit me !");
        f.add(c);
        f.pack();
        f.setLocationRelativeTo(null); //put in center of screen
		f.setVisible(true); //show to the user
        c.addItemListener(new CheckboxClickHandler());
    }
}

class CheckboxClickHandler implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent event) {
        String state = 1 == event.getStateChange() ? "" : "un-";
        System.out.printf("Checkbox was %schecked !%n", state);
    }
}