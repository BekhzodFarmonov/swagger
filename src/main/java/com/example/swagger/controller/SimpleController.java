package com.example.swagger.controller;

import com.example.swagger.servise.ReportSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SimpleController {
    private  final ReportSenderService reportSenderService;
    @GetMapping("/report")
    public String sendReport() {
        reportSenderService.sendReport();
        return "Report Send Suc";
    }
}
