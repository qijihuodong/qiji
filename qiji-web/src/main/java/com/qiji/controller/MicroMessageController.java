package com.qiji.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiji.domain.MicroMessage;
import com.qiji.service.impl.MicroMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MicroMessageController {

    @Autowired
    MicroMessageService microMessageService;

    @RequestMapping("/index")
    public ModelAndView selectList(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam @NotNull Integer isRead){
        MicroMessage param=new MicroMessage();
        param.setIsRead(isRead);

        PageHelper.startPage(pageNum,10);
        List<MicroMessage> list=microMessageService.selectList(param);
        PageInfo<MicroMessage> pageInfo=new PageInfo<>(list);

        return  new ModelAndView("message-list","page",pageInfo);
    }
}
