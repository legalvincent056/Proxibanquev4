package com.huios.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.stereotype.Controller;
 
@Controller
public class ChartView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 6486362711032672304L;
	
	private PieChartModel pieModel1;
    private PieChartModel pieModel2;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Conseiller 1", 540);
        pieModel1.set("Conseiller 2", 325);
        pieModel1.set("Conseiller 3", 702);
        pieModel1.set("Conseiller 4", 421);
         
        pieModel1.setTitle("Graphique de performance des conseillers");
        pieModel1.setLegendPosition("w");
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
         
        pieModel2.set("Conseiller 1", 540);
        pieModel2.set("Conseiller 2", 325);
        pieModel2.set("Conseiller 3", 702);
        pieModel2.set("Conseiller 4", 421);
         
        pieModel2.setTitle("graph exprimé en pourcentage");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
     
}