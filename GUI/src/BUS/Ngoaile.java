
package BUS;

import javax.swing.JOptionPane;

/**
 *
 * @author thuan
 */
public class Ngoaile  extends Funtion {
    String enterPass ;

    public Ngoaile(String newPass, String oldPass,String enterPass) {
        super(newPass, oldPass);
        this.enterPass = enterPass;
        
        if (newPass.isEmpty() ||oldPass.isEmpty()|| enterPass.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Bạn Không Được Để Trống !", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        else if  (!newPass.equals(enterPass)){
            JOptionPane.showMessageDialog(null, "Mật Khẩu xác thực Không Giống  !", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        else{
            doipass doipass = new doipass(newPass,oldPass);
        }
        
    }
}
    

