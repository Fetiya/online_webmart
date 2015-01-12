/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorAdmin;
import edu.mum.cs490.smartmart.service.IReportService;
import edu.mum.cs490.smartmart.service.IVendorService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author senai
 */
@Controller
@RequestMapping("/report")
public class ReportController {

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


    @RequestMapping(value = "/reportSelection", method = RequestMethod.GET)
    public String reportSelector() {
        // return "/report/pdf";
        return "redirect:/reportSelectionView";
        //return "reportSelection";
    }
    
    

    @RequestMapping(value = "/pdf", method = RequestMethod.POST)
    public ModelAndView generatePdfReport(ModelAndView modelAndView, HttpServletRequest request, HttpSession session) {

        logger.debug("--------------generate PDF report----------");

        String reportStartDate = request.getParameter("reportStartDate");
        String reportEndDate = request.getParameter("reportEndDate");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date rptStartDate = formatter.parse(reportStartDate);
            Date rptEndDate = formatter.parse(reportEndDate);

            Users user = (Users) session.getAttribute("loggedUser");
            VendorAdmin vendorAdmin;
            if (user != null && user instanceof VendorAdmin) {
                vendorAdmin = (VendorAdmin) user;
                Vendor vendor = vendorService.getVendorByVendorAdminId(vendorAdmin.getId());

                //pdfReport bean has ben declared in the jasper-views.xml file
                modelAndView = new ModelAndView("pdfReport", jasperReportService.getVendorSalesReportByProduct(vendor.getId(), rptStartDate, rptEndDate));
                return modelAndView;

            } else {
                System.out.println("User is not vendorAdmin");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return modelAndView;

    }//generatePdfReport

    @RequestMapping(value = "/xls", method = RequestMethod.POST)
    public ModelAndView generateXlsReport(ModelAndView modelAndView, HttpServletRequest request, HttpSession session) {

        logger.debug("--------------generate XLS report----------");

        String reportStartDate = request.getParameter("reportStartDate");
        String reportEndDate = request.getParameter("reportEndDate");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date rptStartDate = formatter.parse(reportStartDate);
            Date rptEndDate = formatter.parse(reportEndDate);

            Users user = (Users) session.getAttribute("loggedUser");
            VendorAdmin vendorAdmin;
            if (user != null && user instanceof VendorAdmin) {
                vendorAdmin = (VendorAdmin) user;
                Vendor vendor = vendorService.getVendorByVendorAdminId(vendorAdmin.getId());

                //xlsReport bean has ben declared in the jasper-views.xml file
                modelAndView = new ModelAndView("xlsReport", jasperReportService.getVendorSalesReportByProduct(vendor.getId(), rptStartDate, rptEndDate));

            } else {
                System.out.println("User is not vendorAdmin");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return modelAndView;
    }//generatePdfReport

    @RequestMapping(value = "/csv", method = RequestMethod.POST )
    public ModelAndView generateCsvReport(ModelAndView modelAndView, HttpServletRequest request, HttpSession session) {

        logger.debug("--------------generate CSV report----------");

        String reportStartDate = request.getParameter("reportStartDate");
        String reportEndDate = request.getParameter("reportEndDate");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date rptStartDate = formatter.parse(reportStartDate);
            Date rptEndDate = formatter.parse(reportEndDate);

            Users user = (Users) session.getAttribute("loggedUser");
            VendorAdmin vendorAdmin;
            if (user != null && user instanceof VendorAdmin) {
                vendorAdmin = (VendorAdmin) user;
                Vendor vendor = vendorService.getVendorByVendorAdminId(vendorAdmin.getId());

                //csvReport bean has ben declared in the jasper-views.xml file
                modelAndView = new ModelAndView("csvReport", jasperReportService.getVendorSalesReportByProduct(vendor.getId(), rptStartDate, rptEndDate));

            } else {
                System.out.println("User is not vendorAdmin");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return modelAndView;

    }//generatecsvReport

    @RequestMapping(value = "/html", method = RequestMethod.POST )
    public ModelAndView generateHtmlReport(ModelAndView modelAndView, HttpServletRequest request, HttpSession session) {

        logger.debug("--------------generate HTML report----------");

       String reportStartDate = request.getParameter("reportStartDate");
        String reportEndDate = request.getParameter("reportEndDate");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date rptStartDate = formatter.parse(reportStartDate);
            Date rptEndDate = formatter.parse(reportEndDate);

            Users user = (Users) session.getAttribute("loggedUser");
            VendorAdmin vendorAdmin;
            if (user != null && user instanceof VendorAdmin) {
                vendorAdmin = (VendorAdmin) user;
                Vendor vendor = vendorService.getVendorByVendorAdminId(vendorAdmin.getId());

                //htmlReport bean has ben declared in the jasper-views.xml file
                modelAndView = new ModelAndView("htmlReport", jasperReportService.getVendorSalesReportByProduct(vendor.getId(), rptStartDate, rptEndDate));

            } else {
                System.out.println("User is not vendorAdmin");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return modelAndView;

    }//generatePdfReport

}//ReportController

