package de.lendico.plangenerator.service.api.web;

import de.lendico.plangenerator.dto.PlanRequestDto;
import de.lendico.plangenerator.model.Repayment;

import java.util.List;

/**
 * Service for generating plan.
 *
 * @author Andrei
 *
 */
public interface PlanGeneratorService {

    /**
     * Generate a plan by DTO of input parameters.
     *
     * @param planRequestDto Data transfer object by input params
     *
     * @return repayment plan
     */
    List<Repayment> generatePlan(PlanRequestDto planRequestDto);

}
