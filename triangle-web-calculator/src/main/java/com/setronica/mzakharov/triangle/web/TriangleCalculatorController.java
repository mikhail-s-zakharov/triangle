package com.setronica.mzakharov.triangle.web;

import com.setronica.mzakharov.triangle.model.TriangleConstructionForm;
import com.setronica.mzakharov.triangle.service.TriangleCalculatorService;

import com.setronica.mzakharov.trianglechallenge.ShapeDefinitionException;
import com.setronica.mzakharov.trianglechallenge.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by mzakharov on 11.10.16.
 */

@Controller
public class TriangleCalculatorController {
    @Autowired
    private TriangleCalculatorService triangleCalculatorService;
    private Logger logger = LoggerFactory.getLogger(TriangleCalculatorController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model){
        model.put("triangle", triangleCalculatorService.buildTriangle(5.0d, 5.0d, 5.0d));
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView calculate(@ModelAttribute TriangleConstructionForm triangleConstructionForm){
        ModelAndView mv = new ModelAndView("index");
        return createModelAndView(
                triangleCalculatorService.buildTriangle(
                        triangleConstructionForm.getSideA(),
                        triangleConstructionForm.getSideB(),
                        triangleConstructionForm.getSideC()
                ), null);
    }

    @ExceptionHandler(ShapeDefinitionException.class)
    public ModelAndView handleCalculationError(HttpServletRequest request, Exception e){
        logger.error("Request " + request.getMethod() + " to " + request.getRequestURL() + " raised exception", e);
        return createModelAndView(null, e);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleRequestError(HttpServletRequest request, Exception e){
        logger.error("Request " + request.getMethod() + " to " + request.getRequestURL() + " caused 400/Bad Request", e);
        return createModelAndView(null, new RuntimeException("Request contained malformed or insufficient input", e));
    }

    private ModelAndView createModelAndView(Triangle result, Exception error){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("triangle", result);
        mv.addObject("exception", error);
        return mv;
    }
}
