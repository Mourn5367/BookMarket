package kr.ac.kopo.su.bookmarket.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException extends RuntimeException
{
    @ExceptionHandler(value = RuntimeException.class)
    private ModelAndView handleException(Exception e)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("errorCommon");
        return modelAndView;
    }
}
