package com.ems.employeesystem.controllers;


import com.ems.employeesystem.dtos.InformationDto;
import com.ems.employeesystem.services.InformationService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/info")
public class InformationController {
    @Autowired
    private InformationService informationService;


    @GetMapping("/employee/{employeeId}")
    public List<InformationDto> getInfoByEmployee(@PathVariable Long employeeId) {
        return informationService.getAllInfosByEmployeeId(employeeId);
    }


    @PostMapping("/employee/{employeeId}")
    public void addInfo(@RequestBody InformationDto informationDto, @PathVariable Long employeeId){
        informationService.addInfo(informationDto, employeeId);
    }

    @PostMapping("/employee/file")
    public void addPic(@RequestParam("file")MultipartFile file) throws Exception{
        String directory = "/Users/davin/Downloads/employee-system/src/main/resources/images";
        Files.copy(file.getInputStream(), Paths.get(directory + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
    }

    @GetMapping(value = "/get-image-with-media-type", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImages(@PathVariable String imageName) throws IOException {
        InputStream input = getClass().getResourceAsStream("/Users/davin/Downloads/employee-system/src/main/resources/images/"+ imageName + ".jpeg");
        return input.readAllBytes();
    }



    @DeleteMapping("/{informationId}")
    public void deleteInfoById(@PathVariable Long informationId){
        informationService.deleteInfoById(informationId);
        System.out.println("Deleting.........................."+ informationId);
    }


    @PutMapping("/employee")
    public void updateInfo(@RequestBody InformationDto informationDto){
        informationService.updateInfoById(informationDto);
    }


    @GetMapping("/{informationId}")
    public Optional<InformationDto> getInfoById(@PathVariable Long informationId){
        return informationService.getInfoById(informationId);
    }
}
