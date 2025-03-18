/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author thuan
 */
public class Funtion {
    String newPass ,  oldPass  ;
    public Funtion(String newPass ,String  oldPass ){
        this.newPass = newPass;
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }
}
