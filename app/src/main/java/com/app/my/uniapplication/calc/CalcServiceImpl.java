package com.app.my.uniapplication.calc;

/**
 * Created by 1027 on 2016-09-24.
 */

public class CalcServiceImpl implements CalcService {
    @Override
    public CalcDTO plus(CalcDTO cal) {
        int num1 = cal.getNum1();
        int num2 = cal.getNum2();
        int result = num1 + num2;
        cal.setResult(result);

        return cal;
    }

    @Override
    public CalcDTO minus(CalcDTO cal) {
        return null;
    }

    @Override
    public CalcDTO multi(CalcDTO cal) {
        return null;
    }

    @Override
    public CalcDTO divi(CalcDTO cal) {
        return null;
    }

    @Override
    public CalcDTO rest(CalcDTO cal) {
        return null;
    }
}
