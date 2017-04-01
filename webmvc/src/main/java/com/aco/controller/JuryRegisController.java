package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.JuryRegis;
import com.aco.service.JuryRegisService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/juryRegis")
public class JuryRegisController extends BaseController{

	@Autowired
	private JuryRegisService juryRegisService;
	
	private final static String List="juryRegis/juryRegisList";
	private final static String ADDPAGE="juryRegis/addJuryRegis";
	private final static String EDITPAGE="juryRegis/editJuryRegis";
	
	@RequestMapping("/list")
	public String List(){
		return List;
	}
	@RequestMapping("/addpage")
	public String addPage(){
		return ADDPAGE;
	}
	@RequestMapping("/editPage/{id}")
	public ModelAndView editPage(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(EDITPAGE);
    	mav.addObject("id", id);
    	return mav;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(JuryRegis juryRegis){
		return juryRegisService.addJuryRegis(juryRegis);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(JuryRegis juryRegis){
		return juryRegisService.editJuryRegis(juryRegis);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		return juryRegisService.deleteJuryRegis(id);
	}
	
    @RequestMapping(value="/view/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String queryById(@PathVariable("id") String id){
    	return responseSuccess(juryRegisService.findJuryRegis(id).get(0));
    }
    
    @RequestMapping("/findJuryRegisList")
    @ResponseBody
    public String rolelist(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<JuryRegis> pageResult = juryRegisService.queryByPage(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
}
