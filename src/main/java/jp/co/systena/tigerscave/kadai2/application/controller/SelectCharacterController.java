package jp.co.systena.tigerscave.kadai2.application.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.kadai2.application.model.Brave;
import jp.co.systena.tigerscave.kadai2.application.model.Charaform;
import jp.co.systena.tigerscave.kadai2.application.model.Warrior;
import jp.co.systena.tigerscave.kadai2.application.model.Witch;
import jp.co.systena.tigerscave.kadai2.application.model.Work;

@Controller
public class SelectCharacterController {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/Select", method = RequestMethod.GET) // URLとのマッピング
	public ModelAndView sel(ModelAndView mav) {

		mav.setViewName("SelectCharacter");
		mav.addObject("CharaObj",new Charaform());

		return mav;
	}

	@RequestMapping(value = "/Cmd", method = RequestMethod.POST) // URLとのマッピング
	public ModelAndView cmd(ModelAndView mav,@ModelAttribute Charaform form) {

		Work work = (Work) session.getAttribute("WorkObj");

		if(form.getWork().equals("戦士")) {
		  work = new Brave();
		}else if(form.getWork().equals("魔法使い")){
		  work = new Witch();
		}else if(form.getWork().equals("武闘家")){
		  work = new Warrior();
		}
		work.setName(form.getName());
		session.setAttribute("WorkObj", work);

		mav.setViewName("Cmd");
		mav.addObject("cmdform",form);

		return mav;
	}

	@RequestMapping(value = "/Result", method = RequestMethod.GET) // URLとのマッピング
	public ModelAndView res(ModelAndView mav) {

		Work work = (Work) session.getAttribute("WorkObj");
		work.fight();
		mav.addObject("WorkObj",work);
		mav.setViewName("Result");

		return mav;
	}
}