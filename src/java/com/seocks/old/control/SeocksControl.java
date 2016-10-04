package com.seocks.old.control;

import com.seocks.old.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SeocksControl {

	SeocksDAO seocksDao;

	public void setSeocksDao(SeocksDAO seocksDao) {
		this.seocksDao = seocksDao;
	}


	//��Ī�ý��� �迭
	String shirtsimg [] = {"A01.jpg","A02.jpg","A03.jpg","A04.jpg","A05.jpg","A06.jpg","A07.jpg","A08.jpg","A09.jpg","A10.jpg","A11.jpg","A12.jpg",
						   "B01.jpg","B02.jpg","B03.jpg","B04.jpg","B05.jpg","B06.jpg","B07.jpg","B08.jpg","B09.jpg","B10.jpg","B11.jpg","B12.jpg",
						   "C01.jpg","C02.jpg","C03.jpg","C04.jpg","C05.jpg","C06.jpg","C07.jpg","C08.jpg","C09.jpg","C10.jpg","C11.jpg","C12.jpg",
						   "D01.jpg","D02.jpg","D03.jpg","D04.jpg","D05.jpg","D06.jpg","D07.jpg","D08.jpg","D09.jpg","D10.jpg","D11.jpg","D12.jpg"};
	String pantsimg [] = {"E01.jpg","E02.jpg","E03.jpg","E04.jpg","E05.jpg","E06.jpg","E07.jpg","E08.jpg","E09.jpg","E10.jpg","E11.jpg","E12.jpg",
						  "F01.jpg","F02.jpg","F03.jpg","F04.jpg","F05.jpg","F06.jpg","F08.jpg","F09.jpg","F10.jpg","F11.jpg","F12.jpg"};
	String shoesimg [] = {"G02.jpg","G03.jpg","G04.jpg","G05.jpg","G06.jpg","G07.jpg","G08.jpg","G09.jpg","G10.jpg","G11.jpg","G12.jpg"};


	// ���� ������ ���� �޼ҵ�
	@RequestMapping("/seocksmain.do")
	public ModelAndView seocksmain() {

		// Center�� ���� �����̳� ������ 4���� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getAllCon();

		// Center������ �ѱ� �����͸� ����
		// SeocksMain.jsp�� �̵��Ͻÿ�
		// String viewName, String modelName, Object modelObject�� �Ѱ����� ��� ����
		return new ModelAndView("SeocksMain", "v", v);
	}

	// Outer��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/outer.do")
	public ModelAndView outer(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);
		return mav;
	}

	// Outer �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/seocksinfo.do")
	public ModelAndView campinginfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// T-Shirt��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/tshirt.do")
	public ModelAndView tshirt(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);

		return mav;
	}

	// T-Shirt �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/tshirtinfo.do")
	public ModelAndView tshirtinfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// Shirt��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/shirt.do")
	public ModelAndView shirt(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);

		return mav;
	}

	// Shirt �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/shirtinfo.do")
	public ModelAndView shirtinfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// Mentomen��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/mentomen.do")
	public ModelAndView mentomen(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);

		return mav;
	}

	// Mentomen �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/mentomeninfo.do")
	public ModelAndView mentomeninfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// Pants��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/pants.do")
	public ModelAndView pants(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);

		return mav;
	}

	// Pants �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/pantsinfo.do")
	public ModelAndView pantsinfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// Training��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/training.do")
	public ModelAndView training(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);

		return mav;
	}

	// Training �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/traininginfo.do")
	public ModelAndView traininginfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// Shoes��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/shoes.do")
	public ModelAndView shoes(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);

		return mav;
	}

	// Shoes �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/shoesinfo.do")
	public ModelAndView shoesinfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// Bag��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/bag.do")
	public ModelAndView bag(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);

		return mav;
	}

	// Bag �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/baginfo.do")
	public ModelAndView baginfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// Accessory��ư Ŭ���� ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/accessory.do")
	public ModelAndView accessory(int pcate) {
		// Center�� ���� ��� �����̳ʷ� ���������� �ϴ� �޼ҵ� ȣ��
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockCenter.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("v", v);

		return mav;
	}

	// Accessory �� ��ư�� ������ �����̳ʰ� ǥ�õǴ� �޼ҵ�
	@RequestMapping("/shop/accessoryinfo.do")
	public ModelAndView accessoryinfo(String pno) {
		// Containers�� ���� ��� �����̳� ���������� �ϴ� �޼ҵ� ȣ��
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp�� �̵��Ͻÿ�
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center������ �ѱ� �����͸� ����
		mav.addObject("center", "SeockInfo.jsp");
		// �����̳� �����͸� ContainersCenter.jsp������ �Ѱ���
		mav.addObject("bean", bean);
		return mav;
	}

	// ȸ�� ���� ��ư�� ������ ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/memberjoinform.do")
	public ModelAndView memberjoinform(MemberBean bean) {

		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("center", "MemberJoin.jsp");

		return mav;
	}

	// ȸ�� ���� ��ư�� ������ ����Ǵ� �޼ҵ�
	@RequestMapping("/shop/memberjoin.do")
	public ModelAndView memberjoin(MemberBean bean) {

		// �����ͺ��̽��� ȸ������ �޼ҵ�ȣ��
		seocksDao.insertMember(bean);
		// ȸ�� ����Ʈ�� ���Ͽ� ȸ�� ������ ����� �̷���������� �ľ�
		return new ModelAndView(new RedirectView("seocksmain.do"));
	}

	// ��� ȸ�� ������ �����ϴ� �޼ҵ�
	@RequestMapping("/shop/memberlist.do")
	public ModelAndView memberlist() {

		// ��� ȸ�� ������ ���� �޼ҵ�ȣ��
		List<MemberBean> v = seocksDao.getAllMember();
		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("center", "MemberList.jsp");
		// MemberList.jsp�� ���Ͻ� �ʿ��� �����͸� ����
		mav.addObject("v", v);

		return mav;
	}

	// �� ȸ���� ������ �����ϴ¸޼ҵ�
	@RequestMapping("/shop/memberinfo.do")
	public ModelAndView memberinfo(String id) {

		// ��� ȸ�� ������ ���� �޼ҵ�ȣ��
		MemberBean bean = seocksDao.getOneMember(id);
		ModelAndView mav = new ModelAndView("SeocksMain");

		// MemberList.jsp�� ���Ͻ� �ʿ��� �����͸� ����
		mav.addObject("bean", bean);
		mav.addObject("center", "MemberInfo.jsp");
		return mav;
	}

	// �α��� ȭ�� ����
	@RequestMapping("/shop/login.do")
	public ModelAndView login() {

		return new ModelAndView("SeocksMain", "center", "LoginForm.jsp");
	}

	// �α���
	@RequestMapping("/shop/login1.do")
	public ModelAndView login1(HttpSession session, MemberBean bean) {

		int result = seocksDao.logindb(bean);

		if (result == 1) {
			session.setAttribute("id", bean.getId());

			return new ModelAndView("SeocksMain");
		} else {

			ModelAndView mav = new ModelAndView("seocksmain.do");
			mav.addObject("center", "LoginForm.jsp");
			mav.addObject("msg", 1);
			return mav;
		}

	}

	// �α׾ƿ�
	@RequestMapping("/shop/loginout.do")
	public ModelAndView loginout(HttpSession session) {

		ModelAndView mav = new ModelAndView("SeocksMain");

		session.setAttribute("id", null);

		return mav;
	}

	//�����ϱ� ��ư������ �̵�
	@RequestMapping("/shop/itembuy.do")
	public ModelAndView itembuy(HttpSession session, ItembuyBean bean) {

		String id = (String) session.getAttribute("id");	

		if(id == null) {
			ModelAndView mav = new ModelAndView("SeocksMain");

			mav.addObject("center", "LoginForm.jsp");	
			return mav;
		} else {

			int total = bean.getQty() * bean.getPprice();
			bean.setTotalprice(total);	
			bean.setTemp(id);
			//���� ���ѳ���
			session.setAttribute("buybean", bean);

			ModelAndView mav = new ModelAndView("SeocksMain");
			mav.addObject("bean", bean);
			mav.addObject("center", "ItemBuy.jsp");
			return mav;
		}
	}
	//���� �����ϱ� ��ư������ �̵�
	//input : pno ��ǰ��ȣ		qty ��ǰ�ֹ�����
	//outpuy : bean
	@RequestMapping("/shop/itembuy2.do")
	public ModelAndView itembuy2(HttpSession session, String pno, int qty, String psize) {

		String id = (String) session.getAttribute("id");	
		if(id == null) {
			ModelAndView mav = new ModelAndView("SeocksMain");

			mav.addObject("center", "LoginForm.jsp");	
			return mav;
		} else {//�α��� O
			SeocksBean bean = seocksDao.getOneItem(pno);//�ϳ��� ��ǰ���� �ֱ�
			session.setAttribute("buybean2", bean);
			
			
			SeocksBean buybeanz  = (SeocksBean) session.getAttribute("buybean2");
			
			ModelAndView mav = new ModelAndView("SeocksMain");
			mav.addObject("bean", bean);
			mav.addObject("center", "ItemBuy2.jsp");
			mav.addObject("qty", qty);
			mav.addObject("psize", psize);
			mav.addObject("pno", pno);
			return mav;
		}
	}

	//�����ϴ� ��ǰ�� ����
	@RequestMapping("/shop/itembuyresult.do")
	public ModelAndView itembuyresult(HttpSession session) {

		ItembuyBean buybean  = (ItembuyBean) session.getAttribute("buybean");	
		// �����ͺ��̽��� �����Ͽ� �ϳ��� �ֹ������� �����ϴ� �޼ҵ带 ȣ��
		seocksDao.insertItembuy(buybean);
		session.setAttribute("buybean", null);//�ʱ�ȭ - �׷����� pno�� ����
		// ó�� ȭ������ �̵�
		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("center", "Clear.jsp");
		return mav;
	}

	//���������ϴ� ��ǰ�� ����
	@RequestMapping("/shop/itembuyresult2.do")
	public ModelAndView itembuyresult2(HttpSession session, String psize, String pno, int qty) {

		SeocksBean buybean  = (SeocksBean) session.getAttribute("buybean2");
		String id = (String) session.getAttribute("id");	
		// �����ͺ��̽��� �����Ͽ� �ϳ��� �ֹ������� �����ϴ� �޼ҵ带 ȣ��
		seocksDao.insertItembuy2(buybean, psize, pno, qty,id);
		session.setAttribute("buybean", null);//�ʱ�ȭ - �׷����� pno�� ����
		// ó�� ȭ������ �̵�
		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("center", "Clear.jsp");
		return mav;
	}


	//��ٱ���.�߰�
	@RequestMapping("/shop/itemcart.do")
	public ModelAndView itemcart(HttpSession session,ItembuyBean bean) {

		String id = (String) session.getAttribute("id");	//���̵� ��������

		if(id == null) {//�α��� X
			ModelAndView mav = new ModelAndView("SeocksMain");

			mav.addObject("center", "LoginForm.jsp");	
			return mav;
		} else {//�α��� O


			int total = bean.getQty() * bean.getPprice();//�� ����
			bean.setTotalprice(total);	//bean�� �� ���� �ֱ�
			bean.setTemp(id);

			//���ǿ� cart��� ����� ��ü�� �ҷ���
			Cart cart = (Cart)session.getAttribute("cart");

			//ó�� �α������Ŀ��� īƮ�� ���ǿ� ����Ǿ����� �ʱ⿡
			if(cart == null){
				//īƮ ��ü ����
				cart = new Cart();   
			}
			//īƮ ��ü�� insertcart�޼ҵ带 �̿��Ͽ� �������� ���Ϳ� ����
			cart.insertCart(bean);
			//cartŬ������ ��� ����Ǿ��ٸ� ���ǿ� ������Ѽ� ����
			session.setAttribute("cart", cart);

			ModelAndView mav = new ModelAndView("SeocksMain");	
			mav.addObject("cart", cart.getAllCart());
			mav.addObject("center", "CartList.jsp");
			return mav;
		}
	}

	//īƮ����
	@RequestMapping("/shop/cartdel.do")
	public ModelAndView cartdel(HttpSession session,String pno , int gubun) {

		//���ǿ� cart��� ����� ��ü�� �ҷ���
		Cart cart = (Cart)session.getAttribute("cart");

		if(gubun==1){

			cart.delCart(pno);
		}else if(gubun ==2){

			cart.delAllCart();
		}

		//cartŬ������ ��� ����Ǿ��ٸ� ���ǿ� ������Ѽ� ����
		session.setAttribute("cart", cart);

		ModelAndView mav = new ModelAndView("SeocksMain");	
		mav.addObject("cart", cart.getAllCart());
		mav.addObject("center", "CartList.jsp");
		return mav;
	}


	//īƮ ��ǰ����
	@RequestMapping("/shop/cartlist.do")
	public ModelAndView cartlist(HttpSession session) {

		//���ǿ� cart��� ����� ��ü�� �ҷ���
		Cart cart = (Cart)session.getAttribute("cart");		
		if(cart == null){
			//īƮ ��ü ����
			cart = new Cart();
		}

		//cartŬ������ ��� ����Ǿ��ٸ� ���ǿ� ������Ѽ� ����
		session.setAttribute("cart", cart);

		ModelAndView mav = new ModelAndView("SeocksMain");	
		mav.addObject("cart", cart.getAllCart());
		mav.addObject("center", "CartList.jsp");
		return mav;
	}

	//�ֹ� ��ȸ
	@RequestMapping("/shop/orderlist.do")
	public ModelAndView orderlist(HttpSession session) {

		//���ǿ� cart��� ����� ��ü�� �ҷ���
		String id = (String)session.getAttribute("id");		

		//cartŬ������ ��� ����Ǿ��ٸ� ���ǿ� ������Ѽ� ����
		List<ItembuyBean> v = seocksDao.getAllItem(id);

		ModelAndView mav = new ModelAndView("SeocksMain");	
		mav.addObject("v", v);
		mav.addObject("center", "MemberOrderList.jsp");
		return mav;
	}

	// �Ǹ���Ȳ
	@RequestMapping("/shop/buylist.do")
	public ModelAndView buylist() {

		// buyŬ������ ��� ����Ǿ��ٸ� ���ǿ� ������Ѽ� ����
		List<ItembuyBean> v = seocksDao.getBuyItem();

		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("v", v);
		mav.addObject("center", "BuyList.jsp");
		return mav;
	}



	/////////////////////////////////////////////////////




	// �Ǹ���Ȳ
	@RequestMapping("/shop/shirtsbefore.do")
	public ModelAndView shirtsbefore(int tnum , HttpSession session) {


		if(tnum<=0){
			tnum= 0;
		}						
		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");		
		//��ȣ�� �ٿ���
		mbean.setTnum(tnum);
		//�ش��ȣ�� �´� �̹����� ������
		mbean.setShirtimg(shirtsimg[tnum]);		

		session.setAttribute("mbean", mbean);
		ModelAndView mav = new ModelAndView("SeocksMain");		
		mav.addObject("center", "Matching.jsp");
		mav.addObject("mbean", mbean);
		return mav;
	}

	@RequestMapping("/shop/shirtsnext.do")
	public ModelAndView shirtsnext(int tnum, HttpSession session) {
		if(tnum > shirtsimg.length-1){
			tnum=shirtsimg.length-1;
		}
		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");
		//��ȣ�� �ٿ���
		mbean.setTnum(tnum);
		//�ش��ȣ�� �´� �̹����� ������
		mbean.setShirtimg(shirtsimg[tnum]);		

		session.setAttribute("mbean", mbean);
		ModelAndView mav = new ModelAndView("SeocksMain");		
		mav.addObject("center", "Matching.jsp");
		mav.addObject("mbean", mbean);
		return mav;
	}
	@RequestMapping("/shop/pantsbefore.do")
	public ModelAndView pantsbefore(int pnum, HttpSession session) {
		if(pnum<=0){
			pnum= 0;
		}						
		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");		
		//��ȣ�� �ٿ���
		mbean.setPnum(pnum);
		//�ش��ȣ�� �´� �̹����� ������
		mbean.setPantsimg(pantsimg[pnum]);		

		session.setAttribute("mbean", mbean);
		ModelAndView mav = new ModelAndView("SeocksMain");		
		mav.addObject("center", "Matching.jsp");
		mav.addObject("mbean", mbean);
		return mav;
	}
	@RequestMapping("/shop/pantsnext.do")
	public ModelAndView pantsnext(int pnum, HttpSession session) {
		if(pnum > pantsimg.length-1){
			pnum=pantsimg.length-1;
		}
		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");		
		//��ȣ�� �ٿ���
		mbean.setPnum(pnum);
		//�ش��ȣ�� �´� �̹����� ������
		mbean.setPantsimg(pantsimg[pnum]);			

		session.setAttribute("mbean", mbean);
		ModelAndView mav = new ModelAndView("SeocksMain");		
		mav.addObject("center", "Matching.jsp");
		mav.addObject("mbean", mbean);
		return mav;
	}
	@RequestMapping("/shop/shoesbefore.do")
	public ModelAndView shoesbefore(int snum, HttpSession session) {
		if(snum<=0){
			snum= 0;
		}
		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");		
		//��ȣ�� �ٿ���
		mbean.setSnum(snum);
		//�ش��ȣ�� �´� �̹����� ������
		mbean.setShoesimg(shoesimg[snum]);		

		session.setAttribute("mbean", mbean);
		ModelAndView mav = new ModelAndView("SeocksMain");		
		mav.addObject("center", "Matching.jsp");
		mav.addObject("mbean", mbean);
		return mav;
	}
	@RequestMapping("/shop/shoesnext.do")
	public ModelAndView shoesnext(int snum, HttpSession session) {
		if(snum > shoesimg.length-1){
			snum=shoesimg.length-1;
		}
		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");		
		//��ȣ�� �ٿ���
		mbean.setSnum(snum);
		//�ش��ȣ�� �´� �̹����� ������
		mbean.setShoesimg(shoesimg[snum]);			

		session.setAttribute("mbean", mbean);
		ModelAndView mav = new ModelAndView("SeocksMain");		
		mav.addObject("center", "Matching.jsp");
		mav.addObject("mbean", mbean);
		return mav;
	}
	@RequestMapping("/shop/matching.do")
	public ModelAndView matching(HttpSession session) {

		// buyŬ������ ��� ����Ǿ��ٸ� ���ǿ� ������Ѽ� ����
		List<ItembuyBean> v = seocksDao.getBuyItem();

		ModelAndView mav = new ModelAndView("SeocksMain");

		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");
		if(mbean==null){
			mbean = new MatchingBean();			
		}
		//���� �ʱ�ȭ
		mbean.setShirtimg(shirtsimg[0]);
		mbean.setPantsimg(pantsimg[0]);
		mbean.setShoesimg(shoesimg[0]);
		mbean.setPnum(0);
		mbean.setSnum(0);
		mbean.setTnum(0);
		session.setAttribute("mbean", mbean);

		mav.addObject("mbean", mbean);
		mav.addObject("center", "Matching.jsp");
		return mav;
	}

	
	//��ǰ���
	@RequestMapping("/shop/itemreserveform.do")
	public ModelAndView itemreserveform( HttpSession session) {
		
		return new ModelAndView("SeocksMain", "center", "ItemUpload.jsp");
	}
	
	//
	@RequestMapping("/shop/itemreserve.do")
	public String itemreserve(HttpServletRequest request) throws Exception {
		
		/*
		SeocksBean bean = null;
		// ���� ���Ͼ��ε� ���� ���� ����
		request.setCharacterEncoding("EUC-KR");
		// �ִ� ���Ͼ��ε�� �������� ũ�⸦ ���� 10mbyte
		int maxSize = 1024 * 1024 * 10;
		String realfolder = "C:/MyWork/jsp/Project/WebContent/img";// ������Ʈ�� ��������
		// �̸��� �������
		try {
			// Ŭ���̾�Ʈ�κ��� �Ѿ�� �����͸� ���� ���� ���ε� ������ �����ϴ� �۾�
			MultipartRequest multi = new MultipartRequest(request, realfolder, maxSize, "EUC-KR",
					new DefaultFileRenamePolicy());// ������ �̸��� �ִٸ� ����
			bean = new SeocksBean();
			bean.setPno(multi.getParameter("pno"));
			bean.setPname(multi.getParameter("pname"));
			bean.setPprice(Integer.parseInt(multi.getParameter("pprice")));
			bean.setPinfo(multi.getParameter("pinfo"));
			bean.setPcate(Integer.parseInt(multi.getParameter("pcate")));
			
			// �Ѱ��̻��� ������ ������ �Ѿ�Դٸ�
			Enumeration en = multi.getFileNames();
			String imgarr[] = new String[2];
			int i = 0;
			while (en.hasMoreElements()) {
				// ���� �̸� �ΰ��� �Ѿ��
				String filename = en.nextElement().toString();
				imgarr[i] = multi.getOriginalFileName(filename);
				i++;
			}
			// �迭�� ����� �̹����� bean�� �ٽ�����
			bean.setPmainimg(imgarr[0]);
			bean.setPsubimg(imgarr[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(bean.getPno());
		// no���� ���� �ϴ��� ���θ� �ľ�
		int result = seocksDao.itemcheck(bean.getPno());
		// ����� 0�̶�� ���Ӱ� ����
		if (result == 0) {
			seocksDao.insertItem(bean);
			return new ModelAndView("SeocksMain", "center", "UploadComplate.jsp");
		} else {
			// �̹� �ִ� ��ǰ�̶��
			ModelAndView mav = new ModelAndView("SeocksMain");
			mav.addObject("center", "ItemUpload.jsp");
			mav.addObject("msg", "1");
			return mav;
		}
		*/
		
		return null;
	}
}
