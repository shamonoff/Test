package masterbuildscript;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import org.apache.tools.ant.input.DefaultInputHandler;
import org.apache.tools.ant.input.InputRequest;


public class FODInputHandler
    extends DefaultInputHandler {

    /**
     * The JDialog that contains the component in which the input
     * is typed.
     */
    protected JDialog dlgInput;

    /**
     * The layout of the dialog.
     */
    protected LayoutManager layout;

    /**
     * The label of the input component.
     */
    protected JLabel lblInput;

    /**
     * The JComponent where the input is typed.
     */
    protected JTextField fldInput;

    /**
     * The JButton that will passed the input to the input request.
     */
    protected JButton btnSubmit;

    /**
     * Default no-arg constructor.
     * Initializes the graphical components.
     */
    public FODInputHandler() {
        dlgInput = new JDialog();
        dlgInput.setModal(true);
        layout = new GridBagLayout();
        lblInput = new JLabel();
        fldInput = new JPasswordField();
        btnSubmit = new JButton();
    }


    protected void addWidgets() {
        dlgInput.getContentPane().setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        gbc.insets.bottom = 5;
        gbc.insets.top = 5;
        dlgInput.getContentPane().add(lblInput, gbc);

        gbc.gridx = 1;
        gbc.insets.bottom = 0;
        gbc.insets.top = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dlgInput.getContentPane().add(fldInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets.bottom = 5;
        dlgInput.getContentPane().add(btnSubmit, gbc);
    }

    public void handleInput(InputRequest request) {
        addWidgets();
        setEventListeners(request);

        dlgInput.setTitle("Enter Property");
        lblInput.setText(getPrompt(request));
        fldInput.setPreferredSize(lblInput.getPreferredSize());
        btnSubmit.setText("Continue");
        dlgInput.pack();
        dlgInput.setLocation(getDialogLocation().width, getDialogLocation().height);
        dlgInput.setAlwaysOnTop(true);
        dlgInput.setVisible(true);
    }

    /**
     * Sets AWT Listeners to the components which will recieve or
     * submit the events.
     *
     * @param request the InputRequest object, where the contents
     * of the input component will be set.
     */
    protected void setEventListeners(final InputRequest request) {
        btnSubmit.addActionListener(
            new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                request.setInput(fldInput.getText());
                dlgInput.dispose();
            }
        });

        fldInput.addKeyListener(
            new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    request.setInput(fldInput.getText());
                    dlgInput.dispose();
                }
            }
        });
    }

    /**
     * Calculates the desired location of the dialog on the screen.
     * By default it is in the center of the screen.
     *
     * @return the desired location of the dialog on the screen
     */
    protected Dimension getDialogLocation() {
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dlgInputDim = dlgInput.getSize();
        int dlgInputX = (int)
            ((screenDim.getWidth() - dlgInputDim.getWidth()) / 2);
        int dlgInputY = (int)
            ((screenDim.getHeight() - dlgInputDim.getHeight()) / 2);
        return new Dimension(dlgInputX, dlgInputY);
    }
}