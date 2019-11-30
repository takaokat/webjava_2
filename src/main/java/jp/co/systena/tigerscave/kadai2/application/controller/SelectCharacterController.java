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
import jp.co.systena.tigerscave.kadai2.application.model.Witch;
import jp.co.systena.tigerscave.kadai2.application.model.Work;

@Controller
public class SelectCharacterController {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/Select", method = RequestMethod.GET) // URLとのマッピング
	public ModelAndView sel(ModelAndView mav) {

		mav.setViewName("SelectCharacter");
		mav.addObject("ohage",new Charaform());

		return mav;
	}
	@RequestMapping(value = "/Cmd", method = RequestMethod.POST) // URLとのマッピング
	public ModelAndView cmd(ModelAndView mav,@ModelAttribute Charaform form) {

		Work work = (Work) session.getAttribute("okabe");

		if(form.getWork().equals("勇者")) {

			work = new Brave();


		}else if(form.getWork().equals("魔法使い")){
			work = new Witch();
		}
		work.setName(form.getName());
		session.setAttribute("okabe", work);

		mav.setViewName("Cmd");
		mav.addObject("cmdform",form);

		return mav;
	}
	@RequestMapping(value = "/Result", method = RequestMethod.GET) // URLとのマッピング
	public ModelAndView res(ModelAndView mav) {

		Work work = (Work) session.getAttribute("okabe");
		work.fight();
		mav.addObject("okabe",work);
		mav.setViewName("Result");

		return mav;
	}
}