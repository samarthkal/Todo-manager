package com.todo.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {


    Logger logger= LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload")
    public  String uploadSingleFile(@RequestParam ("image")MultipartFile file){
String str=null;
logger.error("null not allowed {}",str.length());
        logger.info("file name {}",file.getName());
        logger.info("file content {}" ,file.getContentType());
        logger.info("original file name {}",file.getOriginalFilename());
        logger.info("file size {}",file.getSize());
        logger.info("file resource {}",file.getResource());

        return "file upload successfully.";

    }

    @PostMapping("/multiple")
    public String uploadMultipleFile(@RequestParam ("file") MultipartFile [] files){
        Arrays.stream(files).forEach(file -> {

            logger.info("file Name {}",file.getName());
            logger.info("file Size {}",file.getSize());
            logger.info("file content type {}",file.getContentType());
            logger.info("original file name {}",file.getOriginalFilename());
            logger.info("resources {}",file.getResource());
            logger.info("file extra {}",file.isEmpty());


        });

        return "uploaded Multiple File Successfully ";
    }

    @GetMapping("/serve-image")
    public void serverImage(HttpServletResponse response)
    {

try {

   InputStream fileInputStream=new FileInputStream("images/sam@8.pdf");

   response.setContentType(MediaType.IMAGE_JPEG_VALUE);
   response.setContentType(MediaType.APPLICATION_PDF_VALUE);

    StreamUtils.copy(fileInputStream,response.getOutputStream());

}catch (Exception e){
    e.printStackTrace();
}

    }
/*
    @ExceptionHandler(value = {NullPointerException.class, NumberFormatException.class})
    public ResponseEntity<String> nullPointerHandler(NullPointerException ex){

        logger.error("NullPointer Exception {}",ex.getMessage());

        logger.error("Exception message {}",ex.getLocalizedMessage());

        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);


    }

 */
}
