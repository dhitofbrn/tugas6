package tugas6;

/**
 *
 * @author ADAM ARDI
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ControllerTugas {
    ModelTugas modelTugas;
    ViewTugas viewTugas;
    
    
    public ControllerTugas(ModelTugas modelTugas, ViewTugas viewTugas){
        this.modelTugas = modelTugas;
        this.viewTugas = viewTugas;
        
        if (modelTugas.getBanyakData() != 0) { 
            String dataFilm[][] = modelTugas.readFilm(); 
            viewTugas.table.setModel((new JTable(dataFilm, viewTugas.namaKolom)).getModel());
        
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        viewTugas.btnCreate.addActionListener((ActionEvent e) -> {
            if (viewTugas.getJudul().equals("") || viewTugas.getTipe().equals("") 
                    ||viewTugas.getEpisode().equals("")||viewTugas.getGenre().equals("") 
                    || viewTugas.getStatus().equals("") ||viewTugas.getRating().equals("")) {
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            } else {
                String judul = viewTugas.getJudul();
                String tipe = viewTugas.getTipe();
                String episode = viewTugas.getEpisode();
                String genre = viewTugas.getGenre();
                String status = viewTugas.getStatus();
                String rating = viewTugas.getRating();
                
                modelTugas.insertFilm(judul,  tipe,  episode,  genre,  status,  rating);
                
                viewTugas.tfJudul.setText("");
                viewTugas.tfTipe.setText("");
                viewTugas.tfEpisode.setText("");
                viewTugas.tfGenre.setText("");
                viewTugas.tfRating.setText("");
                
            
            }
        });
        
        viewTugas.table.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e){ 
               int baris = viewTugas.table.getSelectedRow();
               int kolom = viewTugas.table.getSelectedColumn();
               String dataterpilih = viewTugas.table.getValueAt(baris, 1).toString();
               
              String judul = viewTugas.table.getValueAt(baris, 2).toString();
              viewTugas.tfJudul.setText(judul);
              String tipe = viewTugas.table.getValueAt(baris, 3).toString();
              viewTugas.tfTipe.setText(tipe);
              String episode = viewTugas.table.getValueAt(baris, 4).toString();
              viewTugas.tfEpisode.setText(episode);
              String genre = viewTugas.table.getValueAt(baris, 5).toString();
              viewTugas.tfGenre.setText(episode);
              String status = viewTugas.table.getValueAt(baris, 6).toString();
              viewTugas.cmbStatus.setSelectedItem(status);
              String rating = viewTugas.table.getValueAt(baris, 7).toString();
              viewTugas.tfRating.setText(rating);
              
              viewTugas.btnUpdate.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent f) {
                       String id= dataterpilih;
                       
                       String judulU = viewTugas.getJudul();
                       String tipeU = viewTugas.getTipe();
                       String episodeU = viewTugas.getEpisode();
                       String genreU = viewTugas.getGenre();
                       String statusU = viewTugas.getStatus();
                       String ratingU = viewTugas.getRating();
                       
                       modelTugas.updateFilm(id, judulU, tipeU, episodeU, genreU, statusU, ratingU);
                       
                 
                       
                     
                   }
               });
              
               
               viewTugas.btnDelete.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent f) {
                       int input = JOptionPane.showConfirmDialog(null,"Apa anda ingin menghapus ini "+ dataterpilih+"?", "Pilih Opsi...",JOptionPane.CANCEL_OPTION);
//
                            if(input == 0) {
                                modelTugas.deleteFilm(dataterpilih);
                                    String dataterpilih="";
                            } else {
                             JOptionPane.showMessageDialog(null,"Tidak Jadi Dihapus");
                        }   }
               });
//              
           }
          
        });
        
        
        
        viewTugas.btnRefresh.addActionListener((ActionEvent e) -> {
            String dataFilm[][] = modelTugas.readFilm();
                   viewTugas.table.setModel(new JTable(dataFilm, viewTugas.namaKolom).getModel());
                   
                   viewTugas.tfJudul.setText("");
                       viewTugas.tfTipe.setText("");
                       viewTugas.tfEpisode.setText("");
                       viewTugas.tfGenre.setText("");
                       viewTugas.tfRating.setText("");
                       
                   
        });
        
         viewTugas.btnSearch.addActionListener((ActionEvent e) -> {
             String cari = viewTugas.tfSearch.getText();
            String dataCariFilm[][] = modelTugas.searchFilm(cari);
                   viewTugas.table.setModel(new JTable(dataCariFilm, viewTugas.namaKolom).getModel());
        });
        
        
    }
    

}