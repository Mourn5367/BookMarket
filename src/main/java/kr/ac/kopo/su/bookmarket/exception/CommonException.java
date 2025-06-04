package kr.ac.kopo.su.bookmarket.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException
{
    @ExceptionHandler(value = CategoryException.class)
    private ModelAndView handleException(HttpServletRequest req ,CategoryException e)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.addObject("category",e.getCategory());
        modelAndView.addObject("url",req.getRequestURL() + "?" + req.getRequestURI());
        modelAndView.addObject("errorMessage",e.getErrorMessage());
        modelAndView.setViewName("errorCommon");
        return modelAndView;
    }
}
