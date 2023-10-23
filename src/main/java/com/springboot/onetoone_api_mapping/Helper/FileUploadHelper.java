package com.springboot.onetoone_api_mapping.Helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    //if you want to upload on static path
   // public final String upload_dir = "/Users/Tanu/Documents/All_Documents/eclipse/one-to-one-api-mapping/src/main/resources/static/image";

    //if you want to add dynamic path in target/resource
    public final String upload_dir = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException
    {}

    public boolean UploadFile(MultipartFile multipartFile) {

        boolean f = false;
        try {

//            InputStream is = multipartFile.getInputStream();
//            byte data[] = new byte[is.available()];
//            is.read();
//
//            OutputStream outputStream = new FileOutputStream(upload_dir+ "/"+multipartFile.getOriginalFilename());
//            outputStream.write(data);

            Files.copy(multipartFile.getInputStream(), Paths.get(upload_dir+ "/"+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            f = true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }
}
