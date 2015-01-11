/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.IProductDAO;
import edu.mum.cs490.smartmart.dao.ProductDAO;
import edu.mum.cs490.smartmart.report.entity.ProductSales;
import edu.mum.cs490.smartmart.service.IReportService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author senai
 */
public class JasperReportServiceImpl implements IReportService {

    private IProductDAO productDAO;

    public IProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

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
    public Map<String, Object> getVendorSalesReportByProduct(long vendorId, Date startDate,Date endDate) {

        Map<String, Object> parameterMap = new HashMap<String, Object>();
        
        List<ProductSales> productsList = productDAO.getPrductsSalesByVendor(vendorId);

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(productsList);

        parameterMap.put("datasource", JRdataSource);

        return parameterMap;

    }

}
