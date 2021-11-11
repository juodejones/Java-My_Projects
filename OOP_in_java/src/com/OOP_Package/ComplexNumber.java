package com.OOP_Package;

public class ComplexNumber {

    private double real, imag;

    public ComplexNumber(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void add(double real, double imag){
        this.real += real;
        this.imag += imag;
    }

    public void add(ComplexNumber cmplxnum){
        add(cmplxnum.getReal(), cmplxnum.getImag());
    }

    public void subtract(double real, double imag){
        this.real -= real;
        this.imag -= imag;
    }

    public void subtract(ComplexNumber cmplxnum){
        subtract(cmplxnum.getReal(), cmplxnum.getImag());
    }
}
