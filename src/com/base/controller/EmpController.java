package com.base.controller;

import java.io.BufferedOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.base.dao.EmpDao;
import com.base.model.Emp;        
@Controller    
public class EmpController {    
    @Autowired    
    EmpDao dao;//will inject dao from XML file    
        
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */    
    @RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("command", new Emp());  
        return "empform";   
    }    
    /*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") Emp emp){    
        dao.save(emp);    
        return "redirect:/viewemp";//will redirect to viewemp request mapping    
    }    
    /* It provides list of employees in model object */    
    @RequestMapping("/viewemp")    
    public String viewemp(Model m){    
        List<Emp> list=dao.getEmployees();    
        m.addAttribute("list",list);  
        return "viewemp";    
    }    
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/editemp/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Emp emp=dao.getEmpById(id);    
        m.addAttribute("command",emp);  
        return "empeditform";    
    }    
    /* It updates model object. */    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Emp emp){    
        dao.update(emp);    
        return "redirect:/viewemp";    
    }    
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewemp";    
    }  
    
    @RequestMapping(value="/viewemp/{pageid}")    
    public String fetchpagination(@PathVariable int pageid,Model m){    
        int total=3;    
        if(pageid==1){}    
        else{    
            pageid=(pageid-1)*total+1;    
        }
        List<Emp> list=dao.getEmployeesByPage(pageid,total); 
          m.addAttribute("list", list);  
        return "viewemp";    
    } 
    
}
