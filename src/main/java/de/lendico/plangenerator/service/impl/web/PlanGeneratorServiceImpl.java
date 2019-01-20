package de.lendico.plangenerator.service.impl.web;

import de.lendico.plangenerator.dto.PlanRequestDto;
import de.lendico.plangenerator.model.Repayment;
import de.lendico.plangenerator.service.api.utils.CalculatorService;
import de.lendico.plangenerator.service.api.web.PlanGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link PlanGeneratorService}.
 *
 * @author Andrei
 *
 */
@Service
public class PlanGeneratorServiceImpl implements PlanGeneratorService {

    @Autowired
    private CalculatorService calculatorService;

    public PlanGeneratorServiceImpl() {

    }

    public PlanGeneratorServiceImpl(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public List<Repayment> generatePlan(final PlanRequestDto planRequestDto) {
        List<Repayment> repayments = new ArrayList<>();
        Integer firstPeriod = 1;
        return generate(repayments, planRequestDto, firstPeriod, planRequestDto.getLoanAmount());
    }

    private List<Repayment> generate(final List<Repayment> repayments,
                                     final PlanRequestDto planRequestDto,
                                     final Integer period,
                                     final BigDecimal outstandingPrincipal) {
        if (period > planRequestDto.getDuration()) {
            return repayments;
        }
        Repayment repayment = generateRepayment(planRequestDto.getLoanAmount(), planRequestDto.getNominalRate(),
                planRequestDto.getDuration(), planRequestDto.getStartDate(), outstandingPrincipal, period);
        repayments.add(repayment);
        return generate(repayments, planRequestDto, period + 1, repayment.getRemainingOutstandingPrincipal());

    }

    private Repayment generateRepayment(final BigDecimal loanAmount,
                                        final Double nominalRate,
                                        final Integer duration,
                                        final LocalDateTime startDate,
                                        final BigDecimal initialOutstandingPrincipal,
                                        final Integer period) {

        Repayment repayment = new Repayment();
        repayment.setDate(startDate.plusMonths(period));
        repayment.setInterest(calculatorService.getInterest(nominalRate,
                initialOutstandingPrincipal));
        repayment.setBorrowerPaymentAmount(calculatorService.getAnnuityPayment(loanAmount,
                nominalRate, duration));
        repayment.setPrincipal(calculatorService.getPrincipal(repayment.getBorrowerPaymentAmount(), repayment.getInterest()));
        repayment.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
        repayment.setRemainingOutstandingPrincipal(
                calculatorService.getRemainingOutstandingPrincipal(
                        initialOutstandingPrincipal, repayment.getPrincipal()));

        return repayment;
    }
}
