package kr.wuhan.controller;

import kr.wuhan.service.WuhanDataService;
import kr.wuhan.vo.WuhanData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class MainController {
    @Autowired
    WuhanDataService wuhanDataService;

    @RequestMapping("/")
    private ModelAndView getMainPage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("where is the console!");
        ModelAndView view = new ModelAndView("test.jsp");
        WuhanData wuhanData = wuhanDataService.getWuhanData();
        view.addObject(wuhanData);

        return view;
    }

    @GetMapping("/test")
    private ModelAndView testMethod() {
        System.out.println("do test!");
        wuhanDataService.getWuhanData();
        return null;
    }
}
