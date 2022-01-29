package com.example.command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CommandMain extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton clearbutton = new JButton("clear");

    public CommandMain(String title) throws HeadlessException {
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearbutton.addActionListener(this);

        Box buttonBox = new Box((BoxLayout.X_AXIS));
        buttonBox.add(clearbutton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // ActionListner用
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== clearbutton){
            history.clear();
            canvas.repaint();
        }
    }

    // MouseMotionListner
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    //WindowsListner
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowActivated(WindowEvent e){};
    public void windowClosed(WindowEvent e){};
    public void windowDeactivated(WindowEvent e){};
    public void windowDeiconified(WindowEvent e){};
    public void windowIconified(WindowEvent e){};
    public void windowOpened(WindowEvent e){};


}
