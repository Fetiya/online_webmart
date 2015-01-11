/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorAdmin;
import edu.mum.cs490.smartmart.service.IReportService;
import edu.mum.cs490.smartmart.service.IVendorService;
import java.util.Calendar;
import java.util.Date;
//import org.convey.user.registration.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

/**
 *
 * @author senai
 */
@Controller
@RequestMapping("/report/")
public class ReportController {//extends ActionSupport {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IReportService jasperReportService;
    
    @Autowired 
    IVendorService vendorService;

    private Date startDate;
    private Date endDate;

    public ReportController() {

        Calendar cal = Calendar.getInstance();
        cal.set(2013, 1, 1);
        startDate = cal.getTime();
        cal.set(2015, 1, 30);
        endDate = cal.getTime();
    }

    //return today date
    public Date getTodayDate() {

        return new Date();
    }

    public IReportService getJasperReportService() {
        return jasperReportService;
    }

    public void setJasperReportService(IReportService jasperReportService) {
        this.jasperReportService = jasperReportService;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

//    public String execute() throws Exception {
//
//        return SUCCESS;
//    }
//    public String display() {
//        return NONE;
//    }
    @RequestMapping(value = "reportSelection", method = RequestMethod.GET)
    public ModelAndView reportSelector(ModelAndView modelAndView, HttpSession session) {
        return generatePdfReport(modelAndView, new Date(), new Date(), session);
//        return "reportSelection";
    }

    @RequestMapping(value = "pdf", method = RequestMethod.GET)
    public ModelAndView generatePdfReport(ModelAndView modelAndView, Date reportStartDate, Date reportEndDate, HttpSession session) {

        logger.debug("--------------generate PDF report----------");
        Users user = (Users) session.getAttribute("loggedUser");
        VendorAdmin vendorAdmin;
        if (user != null && user instanceof VendorAdmin) {
            vendorAdmin = (VendorAdmin) user;
            Vendor vendor=vendorService.getVendorByVendorAdminId(vendorAdmin.getId());
            //pdfReport bean has ben declared in the jasper-views.xml file
            modelAndView = new ModelAndView("pdfReport", jasperReportService.getVendorSalesReportByProduct(vendor.getId(), reportStartDate, reportEndDate));
            return modelAndView;

        } else {
            System.out.println("User is not vendorAdmin");
        }
        
        return modelAndView;

    }//generatePdfReport

//    @RequestMapping(method = RequestMethod.GET , value = "xls")
//    public ModelAndView generateXlsReport(ModelAndView modelAndView){
// 
//        logger.debug("--------------generate XLS report----------");
// 
//        Map<String,Object> parameterMap = new HashMap<String,Object>();
// 
//        List<User> usersList = userDao.retrieveAllRegisteredUsers();
// 
//        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
// 
//        parameterMap.put("datasource", JRdataSource);
// 
//        //xlsReport bean has ben declared in the jasper-views.xml file
//        modelAndView = new ModelAndView("xlsReport", parameterMap);
// 
//        return modelAndView;
// 
//    }//generatePdfReport
// 
//    @RequestMapping(method = RequestMethod.GET , value = "csv")
//    public ModelAndView generateCsvReport(ModelAndView modelAndView){
// 
//        logger.debug("--------------generate CSV report----------");
// 
//        Map<String,Object> parameterMap = new HashMap<String,Object>();
// 
//        List<User> usersList = userDao.retrieveAllRegisteredUsers();
// 
//        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
// 
//        parameterMap.put("datasource", JRdataSource);
// 
//        //xlsReport bean has ben declared in the jasper-views.xml file
//        modelAndView = new ModelAndView("csvReport", parameterMap);
// 
//        return modelAndView;
// 
//    }//generatePdfReport
    @RequestMapping(method = RequestMethod.GET, value = "html")
    public ModelAndView generateHtmlReport(ModelAndView modelAndView) {

        logger.debug("--------------generate HTML report----------");

        Map<String, Object> parameterMap = new HashMap<String, Object>();

//        List<User> usersList = userDao.retrieveAllRegisteredUsers();
// 
//        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
//        parameterMap.put("datasource", JRdataSource);
        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("htmlReport", parameterMap);

        return modelAndView;

    }//generatePdfReport

}//ReportController

