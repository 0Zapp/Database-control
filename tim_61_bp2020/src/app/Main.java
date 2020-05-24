package app;

import gui.MainFrame;
import resource.data.Row;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AppCore appCore = new AppCore();
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setAppCore(appCore);


        mainFrame.getAppCore().readDataFromTable("COUNTRIES");
        mainFrame.getAppCore().loadResource();


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainFrame.getAppCore().readDataFromTable("DEPARTMENTS");
    }

}
