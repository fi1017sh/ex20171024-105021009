import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int fmW=500,fmH=450;
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmf = new JMenu("File");
    private JMenu jms = new JMenu("Set");
    private JMenu jmg = new JMenu("Game");
    private JMenu jma = new JMenu("About");
    private JMenuItem jmiE = new JMenuItem("Exit");
    private JMenuItem jmiG = new JMenuItem("樂透");
    private JDesktopPane jdp = new JDesktopPane();
    private JInternalFrame jif = new JInternalFrame();

    private LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame = login;
        initComp();
    }


    private void initComp(){
        this.setBounds(screenW/2-fmW/2,screenH/2-fmH/2,fmW,fmH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        jmb.add(jmf);
        jmb.add(jms);
        jmb.add(jmg);
        jmb.add(jma);

        jmf.add(jmiE);
        jmg.add(jmiG);
        jmiE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        jmiE.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        this.setContentPane(jdp);
        jif.setBounds(0,0,200,80);
        jmiG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jdp.add(jif);
                jif.setVisible(true);
            }
        });
    }
}
