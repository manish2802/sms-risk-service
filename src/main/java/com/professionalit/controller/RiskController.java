package com.professionalit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professionalit.model.RiskRequest;
import com.professionalit.model.RiskResponse;
import com.professionalit.service.RiskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/risk")
@RequiredArgsConstructor
public class RiskController {

	private final RiskService riskService;

    @PostMapping("/validate")
    public ResponseEntity<RiskResponse> validateRisk(
            @RequestBody RiskRequest request) {

        return ResponseEntity.ok(
                riskService.validateRisk(request)
        );
    }
}