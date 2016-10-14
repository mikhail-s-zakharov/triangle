package com.setronica.mzakharov.triangle.service;

import com.setronica.mzakharov.trianglechallenge.Triangle;
import org.springframework.stereotype.Service;

/**
 * Created by mzakharov on 11.10.16.
 * Service to operate with triangle calculations
 */

@Service
public class TriangleCalculatorService {
    /*
    * just a dumb factory method
    * */
    public Triangle buildTriangle(double a, double b, double c){
        return new Triangle(a, b, c);
    }
}
