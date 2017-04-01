package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.PoliceBasicInfo;
import com.aco.model.SocialRelations;
import com.aco.service.PoliceBasicInfoService;
import com.aco.service.SocialRelationsService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/socialRelations")
public class SocialRelationsController extends BaseController{

	@Autowired
	private SocialRelationsService socialRelationsService;
	
	private final static String List="socialRelations/socialRelationsList";
	private final static String ADDPAGE="socialRelations/addSocialRelations";
	private final static String EDITPAGE="socialRelations/editSocialRelations";
	
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
	public String add(SocialRelations socialRelations){
		return socialRelationsService.addSocialRelations(socialRelations);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(SocialRelations socialRelations){
		return socialRelationsService.editSocialRelations(socialRelations);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		return socialRelationsService.deleteSocialRelations(id);
	}
	
    @RequestMapping(value="/view/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String queryById(@PathVariable("id") String id){
    	return responseSuccess(socialRelationsService.findSocialRelations(id).get(0));
    }
    
    @RequestMapping("/findSocialRelationsList")
    @ResponseBody
    public String rolelist(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<SocialRelations> pageResult = socialRelationsService.queryByPage(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
}
