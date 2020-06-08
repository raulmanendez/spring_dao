package com.base.model;

 
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import javax.servlet.ServletContext;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.multipart.commons.CommonsMultipartFile;  
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
public class EmpFile {  
    private static final String UPLOAD_DIRECTORY ="/images";  
      
    @RequestMapping("uploadform")  
    public ModelAndView uploadForm(){  
        return new ModelAndView("fileupload");    
    }  
      
    @RequestMapping(value="savefile",method=RequestMethod.POST)  
    public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,  
           HttpSession session) throws Exception{  
  
    ServletContext context = session.getServletContext();  
    
    System.out.println("context"+context);
    
    String path = context.getRealPath(UPLOAD_DIRECTORY);  
    
    System.out.println("path"+path);
    
    String filename = file.getOriginalFilename();  
  
    System.out.println(path+" "+filename);        
  
    byte[] bytes = file.getBytes(); 
    
    System.out.println("bytes"+bytes);
    
    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
         new File(path + File.separator + filename))); 
    System.out.println("checkpont 0 ");
    stream.write(bytes);  
    System.out.println("checkpont 1 ");
    stream.flush();  
    System.out.println("checkpont 2 ");
    stream.close();  
     
    System.out.println("checkpont 3 ");  
    
    return new ModelAndView("fileupload","filesuccess","File successfully saved!");  
    }  
}  
