/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas6;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADAM ARDI
 */
public class ViewTugas extends JFrame {
    
JTable table;
DefaultTableModel tableModel;
JScrollPane scrollPane;
Object namaKolom[] = {"#","ID","Judul","Tipe","Episode","Genre","Status","Rating"};

JLabel lJudul = new JLabel(" JUDUL ");
JTextField tfJudul = new JTextField();
JTextField tfSearch = new JTextField();
JButton btnSearch = new JButton(" SEARCH ");
JLabel lTipe = new JLabel(" TIPE ");
JTextField tfTipe = new JTextField();
JLabel lStatus = new JLabel(" STATUS ");
String[] namaStatus =
            {" Belum Selesai "," Selesai "};
JComboBox cmbStatus = new JComboBox(namaStatus);
JLabel lEpisode = new JLabel(" EPISODE ");
JTextField tfEpisode = new JTextField();
JLabel lRating = new JLabel(" RATING ");
JTextField tfRating = new JTextField();
JLabel lGenre = new JLabel(" GENRE ");
JTextField tfGenre = new JTextField();
JButton btnRefresh = new JButton(" REFRESH ");
JButton btnCreate = new JButton(" CREATE ");
JButton btnUpdate = new JButton(" UPDATE ");
JButton btnDelete = new JButton(" DELETE");
JButton btnExit= new JButton(" CLOSE ");

public ViewTugas(){
tableModel = new DefaultTableModel(namaKolom,0);
table = new JTable(tableModel);
scrollPane = new JScrollPane(table);

setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
setLayout(null);
setSize(900, 700);

add(scrollPane);
scrollPane.setBounds(20,20,800,190);
scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

add(lJudul);
lJudul.setBounds(20, 225, 100, 20);
add(tfJudul);
tfJudul.setBounds(20, 250, 200, 20);
add(tfSearch);
tfSearch.setBounds(420, 250, 200, 20);
add(btnSearch);
btnSearch.setBounds(640, 250, 100, 20);
add(lTipe);
lTipe.setBounds(20, 280, 100, 20);
add(tfTipe);
tfTipe.setBounds(20, 310, 120, 20);
add(lStatus);
lStatus.setBounds(200, 280, 100, 20);
add(cmbStatus);
cmbStatus.setBounds(200, 310, 130, 20);
add(lRating);
lRating.setBounds(200, 340, 100, 20);
add(tfRating);
tfRating.setBounds(200, 370, 130, 20);
add(lEpisode);
lEpisode.setBounds(20, 340, 100, 20);
add(tfEpisode);
tfEpisode.setBounds(20, 370, 120, 20);
add(lGenre);
lGenre.setBounds(20, 410, 100, 20);
add(tfGenre);
tfGenre.setBounds(20, 440, 130, 20);
add(btnRefresh);
btnRefresh.setBounds(200, 440, 100, 20);
add(btnCreate);
btnCreate.setBounds(320, 440, 100, 20);
add(btnUpdate);
btnUpdate.setBounds(440, 440, 100, 20);
add(btnDelete);
btnDelete.setBounds(560, 440, 100, 20);
add(btnExit);
btnExit.setBounds(680, 440, 100, 20);


}

public String getJudul(){
    return tfJudul.getText();
}
public String getTipe(){
    return tfTipe.getText();
}
public String getStatus(){
    return (String) cmbStatus.getSelectedItem();
}
public String getEpisode(){
    return tfEpisode.getText();
}
public String getRating(){
    return tfRating.getText();
}
public String getGenre(){
    return tfGenre.getText();
}



}