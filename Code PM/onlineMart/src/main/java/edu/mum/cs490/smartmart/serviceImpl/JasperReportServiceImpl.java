/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.service.IReportService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author senai
 */
public class JasperReportServiceImpl implements IReportService {

//    public void generateReport(List>) {
//        try{
//        InputStream inputStream = new FileInputStream("reports/test_jasper.jrxml");        
////        DataBeanMaker dataBeanMaker = new DataBeanMaker();
//        ArrayList<databean> dataBeanList = dataBeanMaker.getDataBeanList();
//
//        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
//
//        Map parameters = new HashMap();
//
//        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, "c:/reports/test_jasper.pdf");
//        }catch(FileNotFoundException exception){
//            System.out.println("Report File Could not be found");
//        }
//    }

}
