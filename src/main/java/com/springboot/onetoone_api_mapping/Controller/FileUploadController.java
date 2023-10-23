package com.springboot.onetoone_api_mapping.Controller;

import com.springboot.onetoone_api_mapping.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    FileUploadHelper fileUploadHelper;
    @PostMapping("/file-upload")
    public ResponseEntity<String> UploadFile(@RequestParam("file") MultipartFile multipartFile)
    {
        System.out.println(multipartFile.getContentType());
        try
        {
            if(multipartFile.isEmpty())
            {
                return ResponseEntity.ok("File is emplty");
            }
            if(!multipartFile.getContentType().equals("image/jpeg"))
            {
                return ResponseEntity.ok("Only iamge/jpeg file can upload");
            }
            boolean f = fileUploadHelper.UploadFile(multipartFile);
            if(f)
            {
                //return ResponseEntity.ok("file uploaded");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString());
            }
            else
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
