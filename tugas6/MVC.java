/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas6;

/**
 *
 * @author ADAM ARDI
 */
public class MVC {
    ModelTugas modelTugas = new ModelTugas();
    ViewTugas viewTugas= new ViewTugas();
    ControllerTugas controllerTugas = new ControllerTugas(modelTugas, viewTugas);
    
    
}