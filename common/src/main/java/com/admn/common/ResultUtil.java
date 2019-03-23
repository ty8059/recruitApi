package com.admn.common;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class ResultUtil {

    /**
     * 验证model是否处错
     * @param bindingResult bindingResult
     * @return
     */
    public static ResultEntity validModel(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError objectError : errors) {
                FieldError error = (FieldError) objectError;
                return new ResultEntity(false, error.getDefaultMessage());
            }
        }
        return new ResultEntity(true, "条件满足");
    }

    /**
     * @Author wangyi
     * @Description // 给model添加error错误信息,以供返回错误页面使用
     * @Date 2019/1/23
     * @Param [msg, model]
     * @return void
     **/
    public static String errorModel(String msg, Model model) {
        model.addAttribute("error", new ResultEntity(false, msg));
        return "errorPage";
    }

    /**
     * @Author wangyi
     * @Description // 给modelAndView添加error错误信息,以供返回错误页面使用
     * @Date 2019/1/23
     * @Param [msg, model]
     * @return void
     **/
    public static ModelAndView errorModel(String msg, ModelAndView modelAndView) {
        modelAndView.addObject("error", new ResultEntity(false, msg));
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }
}
