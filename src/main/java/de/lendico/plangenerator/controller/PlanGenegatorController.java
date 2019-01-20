package de.lendico.plangenerator.controller;

import de.lendico.plangenerator.dto.PlanRequestDto;
import de.lendico.plangenerator.model.Repayment;
import de.lendico.plangenerator.controller.model.request.PlanRequest;
import de.lendico.plangenerator.service.api.web.PlanGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * A web controller for generating plan.
 *
 * @author Andrei
 *
 */
@RestController
@RequestMapping("/generate-plan")
public class PlanGenegatorController {

    @Autowired
    private PlanGeneratorService planGeneratorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Repayment> generatePlan(@Valid @RequestBody PlanRequest request) {
        PlanRequestDto planRequestDto = new PlanRequestDto(request.getLoanAmount(),
                request.getNominalRate(), request.getDuration(), request.getStartDate());
        return planGeneratorService.generatePlan(planRequestDto);
    }
}
