/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapesapp;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import za.ac.tut.shape.Shape;
import za.ac.tut.shape.circle.Circle;
import za.ac.tut.shape.sector.Sector;
import za.ac.tut.shapesprocessor.ShapesProcessor;


/**
 *
 * @author tresorkl
 */
public class ShapesApp {

    /**
     * @param args the command line arguments
     */
    
    
    public static void displayInformation(List<Shape> shapes,List<Double> areas, Shape shapeWithLargestArea){
          String info="";
          Circle circle;
          Sector sector; 
          DecimalFormat df = new DecimalFormat("0.00");
        for(int i = 0; i< shapes.size(); i++ ){
          

            if(shapes.get(i) instanceof Circle){
                
                circle= (Circle)shapes.get(i);
               
                info = info + ( "Shape Type: Circle" + "\n" + "Area: "+df.format(areas.get(i)) +"\n"+ "Incread Radius :"+circle.getRadius()).concat("\n\n");
                
                
            }else{
                
                 sector = (Sector) shapes.get(i);
                
                info = info + ( "Shape Type: Sector" + "\n"  + "Area: "+df.format(areas.get(i)) +"\n"+
                     "Thetha :"+sector.getAngleTheta()+"\n"+ "Incread Radius :"+sector.getRadius()).concat("\n\n");
                
            }
            
        }
        
        info = info+("Shape With Largest Area: "+shapeWithLargestArea.toString()).concat("\n\n");
        
        JOptionPane.showMessageDialog(null, info, "SHAPES INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
   
    
    
    public static void main(String[] args) {
       
        List<Shape> shapes = new ArrayList<>();
        
        List<Double> areas = new ArrayList<>();
        
        String shapesInfo = "C-10#C-20#C-5#S-20-45#S-30-60#C-10" ;
       
        ShapesProcessor processor = new ShapesProcessor();
        
        //populate shopes list
        processor.populateShapes(shapes, shapesInfo);
        
       
        // calculate Shapes Areas
        
        processor.calculateShapesAreas(shapes, areas);
        
        // increase Shapes Angles
      //  processor.increaseShapesAngles(shapes, 0.5);
       
        // shape With Largest Area
        Shape shapeWithLargestArea = processor.determineShapeWithLargestArea(shapes, areas);
        
        
        // display method
        displayInformation( shapes, areas,shapeWithLargestArea);
    }
    
}
