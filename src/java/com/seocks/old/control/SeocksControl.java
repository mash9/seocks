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


	//매칭시스템 배열
	String shirtsimg [] = {"A01.jpg","A02.jpg","A03.jpg","A04.jpg","A05.jpg","A06.jpg","A07.jpg","A08.jpg","A09.jpg","A10.jpg","A11.jpg","A12.jpg",
						   "B01.jpg","B02.jpg","B03.jpg","B04.jpg","B05.jpg","B06.jpg","B07.jpg","B08.jpg","B09.jpg","B10.jpg","B11.jpg","B12.jpg",
						   "C01.jpg","C02.jpg","C03.jpg","C04.jpg","C05.jpg","C06.jpg","C07.jpg","C08.jpg","C09.jpg","C10.jpg","C11.jpg","C12.jpg",
						   "D01.jpg","D02.jpg","D03.jpg","D04.jpg","D05.jpg","D06.jpg","D07.jpg","D08.jpg","D09.jpg","D10.jpg","D11.jpg","D12.jpg"};
	String pantsimg [] = {"E01.jpg","E02.jpg","E03.jpg","E04.jpg","E05.jpg","E06.jpg","E07.jpg","E08.jpg","E09.jpg","E10.jpg","E11.jpg","E12.jpg",
						  "F01.jpg","F02.jpg","F03.jpg","F04.jpg","F05.jpg","F06.jpg","F08.jpg","F09.jpg","F10.jpg","F11.jpg","F12.jpg"};
	String shoesimg [] = {"G02.jpg","G03.jpg","G04.jpg","G05.jpg","G06.jpg","G07.jpg","G08.jpg","G09.jpg","G10.jpg","G11.jpg","G12.jpg"};


	// 메인 페이지 시작 메소드
	@RequestMapping("/seocksmain.do")
	public ModelAndView seocksmain() {

		// Center에 붙일 컨테이너 데이터 4개만 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getAllCon();

		// Center쪽으로 넘길 데이터를 부착
		// SeocksMain.jsp로 이동하시오
		// String viewName, String modelName, Object modelObject를 한곳에서 사용 가능
		return new ModelAndView("SeocksMain", "v", v);
	}

	// Outer버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/outer.do")
	public ModelAndView outer(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);
		return mav;
	}

	// Outer 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/seocksinfo.do")
	public ModelAndView campinginfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// T-Shirt버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/tshirt.do")
	public ModelAndView tshirt(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);

		return mav;
	}

	// T-Shirt 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/tshirtinfo.do")
	public ModelAndView tshirtinfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// Shirt버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/shirt.do")
	public ModelAndView shirt(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);

		return mav;
	}

	// Shirt 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/shirtinfo.do")
	public ModelAndView shirtinfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// Mentomen버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/mentomen.do")
	public ModelAndView mentomen(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);

		return mav;
	}

	// Mentomen 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/mentomeninfo.do")
	public ModelAndView mentomeninfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// Pants버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/pants.do")
	public ModelAndView pants(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);

		return mav;
	}

	// Pants 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/pantsinfo.do")
	public ModelAndView pantsinfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// Training버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/training.do")
	public ModelAndView training(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);

		return mav;
	}

	// Training 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/traininginfo.do")
	public ModelAndView traininginfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// Shoes버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/shoes.do")
	public ModelAndView shoes(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);

		return mav;
	}

	// Shoes 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/shoesinfo.do")
	public ModelAndView shoesinfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// Bag버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/bag.do")
	public ModelAndView bag(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);

		return mav;
	}

	// Bag 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/baginfo.do")
	public ModelAndView baginfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// Accessory버튼 클릭시 실행되는 메소드
	@RequestMapping("/shop/accessory.do")
	public ModelAndView accessory(int pcate) {
		// Center에 붙일 모든 컨테이너룰 가져오도록 하는 메소드 호출
		List<SeocksBean> v = seocksDao.getFourCon( pcate);

		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockCenter.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("v", v);

		return mav;
	}

	// Accessory 상세 버튼을 누르면 컨테이너가 표시되는 메소드
	@RequestMapping("/shop/accessoryinfo.do")
	public ModelAndView accessoryinfo(String pno) {
		// Containers에 붙일 모든 컨테이너 가져오도록 하는 메소드 호출
		SeocksBean bean = seocksDao.getOneCon(pno);
		// CampingMain.jsp로 이동하시오
		ModelAndView mav = new ModelAndView("SeocksMain");
		// Center쪽으로 넘길 데이터를 부착
		mav.addObject("center", "SeockInfo.jsp");
		// 컨테이너 데이터를 ContainersCenter.jsp쪽으로 넘겨줌
		mav.addObject("bean", bean);
		return mav;
	}

	// 회원 가입 버튼을 누르면 실행되는 메소드
	@RequestMapping("/shop/memberjoinform.do")
	public ModelAndView memberjoinform(MemberBean bean) {

		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("center", "MemberJoin.jsp");

		return mav;
	}

	// 회원 가입 버튼을 누르면 실행되는 메소드
	@RequestMapping("/shop/memberjoin.do")
	public ModelAndView memberjoin(MemberBean bean) {

		// 데이터베이스의 회원가입 메소드호출
		seocksDao.insertMember(bean);
		// 회원 리스트를 통하여 회원 가입이 제대로 이루어졌는지를 파악
		return new ModelAndView(new RedirectView("seocksmain.do"));
	}

	// 모든 회원 정보를 리턴하는 메소드
	@RequestMapping("/shop/memberlist.do")
	public ModelAndView memberlist() {

		// 모든 회원 정보를 리턴 메소드호출
		List<MemberBean> v = seocksDao.getAllMember();
		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("center", "MemberList.jsp");
		// MemberList.jsp로 리턴시 필요한 데이터를 부착
		mav.addObject("v", v);

		return mav;
	}

	// 한 회원의 정보를 리턴하는메소드
	@RequestMapping("/shop/memberinfo.do")
	public ModelAndView memberinfo(String id) {

		// 모든 회원 정보를 리턴 메소드호출
		MemberBean bean = seocksDao.getOneMember(id);
		ModelAndView mav = new ModelAndView("SeocksMain");

		// MemberList.jsp로 리턴시 필요한 데이터를 부착
		mav.addObject("bean", bean);
		mav.addObject("center", "MemberInfo.jsp");
		return mav;
	}

	// 로그인 화면 띄우기
	@RequestMapping("/shop/login.do")
	public ModelAndView login() {

		return new ModelAndView("SeocksMain", "center", "LoginForm.jsp");
	}

	// 로그인
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

	// 로그아웃
	@RequestMapping("/shop/loginout.do")
	public ModelAndView loginout(HttpSession session) {

		ModelAndView mav = new ModelAndView("SeocksMain");

		session.setAttribute("id", null);

		return mav;
	}

	//구매하기 버튼누르면 이동
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
			//저장 시켜놓음
			session.setAttribute("buybean", bean);

			ModelAndView mav = new ModelAndView("SeocksMain");
			mav.addObject("bean", bean);
			mav.addObject("center", "ItemBuy.jsp");
			return mav;
		}
	}
	//개별 구매하기 버튼누르면 이동
	//input : pno 상품번호		qty 상품주문수량
	//outpuy : bean
	@RequestMapping("/shop/itembuy2.do")
	public ModelAndView itembuy2(HttpSession session, String pno, int qty, String psize) {

		String id = (String) session.getAttribute("id");	
		if(id == null) {
			ModelAndView mav = new ModelAndView("SeocksMain");

			mav.addObject("center", "LoginForm.jsp");	
			return mav;
		} else {//로그인 O
			SeocksBean bean = seocksDao.getOneItem(pno);//하나의 상품정보 넣기
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

	//결제하는 상품을 리턴
	@RequestMapping("/shop/itembuyresult.do")
	public ModelAndView itembuyresult(HttpSession session) {

		ItembuyBean buybean  = (ItembuyBean) session.getAttribute("buybean");	
		// 데이터베이스에 접근하여 하나의 주문정보를 저장하는 메소드를 호출
		seocksDao.insertItembuy(buybean);
		session.setAttribute("buybean", null);//초기화 - 그래야지 pno를 받음
		// 처음 화면으로 이동
		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("center", "Clear.jsp");
		return mav;
	}

	//개별결제하는 상품을 리턴
	@RequestMapping("/shop/itembuyresult2.do")
	public ModelAndView itembuyresult2(HttpSession session, String psize, String pno, int qty) {

		SeocksBean buybean  = (SeocksBean) session.getAttribute("buybean2");
		String id = (String) session.getAttribute("id");	
		// 데이터베이스에 접근하여 하나의 주문정보를 저장하는 메소드를 호출
		seocksDao.insertItembuy2(buybean, psize, pno, qty,id);
		session.setAttribute("buybean", null);//초기화 - 그래야지 pno를 받음
		// 처음 화면으로 이동
		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("center", "Clear.jsp");
		return mav;
	}


	//장바구니.추가
	@RequestMapping("/shop/itemcart.do")
	public ModelAndView itemcart(HttpSession session,ItembuyBean bean) {

		String id = (String) session.getAttribute("id");	//아이디 가져오기

		if(id == null) {//로그인 X
			ModelAndView mav = new ModelAndView("SeocksMain");

			mav.addObject("center", "LoginForm.jsp");	
			return mav;
		} else {//로그인 O


			int total = bean.getQty() * bean.getPprice();//총 가격
			bean.setTotalprice(total);	//bean에 총 가격 넣기
			bean.setTemp(id);

			//세션에 cart라고 저장된 객체를 불러옴
			Cart cart = (Cart)session.getAttribute("cart");

			//처음 로그인한후에는 카트가 세션에 저장되어있지 않기에
			if(cart == null){
				//카트 객체 생성
				cart = new Cart();   
			}
			//카트 객체의 insertcart메소드를 이용하여 아이템을 백터에 저장
			cart.insertCart(bean);
			//cart클래스에 모두 저장되었다면 세션에 저장시켜서 유지
			session.setAttribute("cart", cart);

			ModelAndView mav = new ModelAndView("SeocksMain");	
			mav.addObject("cart", cart.getAllCart());
			mav.addObject("center", "CartList.jsp");
			return mav;
		}
	}

	//카트삭제
	@RequestMapping("/shop/cartdel.do")
	public ModelAndView cartdel(HttpSession session,String pno , int gubun) {

		//세션에 cart라고 저장된 객체를 불러옴
		Cart cart = (Cart)session.getAttribute("cart");

		if(gubun==1){

			cart.delCart(pno);
		}else if(gubun ==2){

			cart.delAllCart();
		}

		//cart클래스에 모두 저장되었다면 세션에 저장시켜서 유지
		session.setAttribute("cart", cart);

		ModelAndView mav = new ModelAndView("SeocksMain");	
		mav.addObject("cart", cart.getAllCart());
		mav.addObject("center", "CartList.jsp");
		return mav;
	}


	//카트 상품보기
	@RequestMapping("/shop/cartlist.do")
	public ModelAndView cartlist(HttpSession session) {

		//세션에 cart라고 저장된 객체를 불러옴
		Cart cart = (Cart)session.getAttribute("cart");		
		if(cart == null){
			//카트 객체 생성
			cart = new Cart();
		}

		//cart클래스에 모두 저장되었다면 세션에 저장시켜서 유지
		session.setAttribute("cart", cart);

		ModelAndView mav = new ModelAndView("SeocksMain");	
		mav.addObject("cart", cart.getAllCart());
		mav.addObject("center", "CartList.jsp");
		return mav;
	}

	//주문 조회
	@RequestMapping("/shop/orderlist.do")
	public ModelAndView orderlist(HttpSession session) {

		//세션에 cart라고 저장된 객체를 불러옴
		String id = (String)session.getAttribute("id");		

		//cart클래스에 모두 저장되었다면 세션에 저장시켜서 유지
		List<ItembuyBean> v = seocksDao.getAllItem(id);

		ModelAndView mav = new ModelAndView("SeocksMain");	
		mav.addObject("v", v);
		mav.addObject("center", "MemberOrderList.jsp");
		return mav;
	}

	// 판매현황
	@RequestMapping("/shop/buylist.do")
	public ModelAndView buylist() {

		// buy클래스에 모두 저장되었다면 세션에 저장시켜서 유지
		List<ItembuyBean> v = seocksDao.getBuyItem();

		ModelAndView mav = new ModelAndView("SeocksMain");
		mav.addObject("v", v);
		mav.addObject("center", "BuyList.jsp");
		return mav;
	}



	/////////////////////////////////////////////////////




	// 판매현황
	@RequestMapping("/shop/shirtsbefore.do")
	public ModelAndView shirtsbefore(int tnum , HttpSession session) {


		if(tnum<=0){
			tnum= 0;
		}						
		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");		
		//번호를 줄여줌
		mbean.setTnum(tnum);
		//해당번호에 맞는 이미지를 가져옴
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
		//번호를 줄여줌
		mbean.setTnum(tnum);
		//해당번호에 맞는 이미지를 가져옴
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
		//번호를 줄여줌
		mbean.setPnum(pnum);
		//해당번호에 맞는 이미지를 가져옴
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
		//번호를 줄여줌
		mbean.setPnum(pnum);
		//해당번호에 맞는 이미지를 가져옴
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
		//번호를 줄여줌
		mbean.setSnum(snum);
		//해당번호에 맞는 이미지를 가져옴
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
		//번호를 줄여줌
		mbean.setSnum(snum);
		//해당번호에 맞는 이미지를 가져옴
		mbean.setShoesimg(shoesimg[snum]);			

		session.setAttribute("mbean", mbean);
		ModelAndView mav = new ModelAndView("SeocksMain");		
		mav.addObject("center", "Matching.jsp");
		mav.addObject("mbean", mbean);
		return mav;
	}
	@RequestMapping("/shop/matching.do")
	public ModelAndView matching(HttpSession session) {

		// buy클래스에 모두 저장되었다면 세션에 저장시켜서 유지
		List<ItembuyBean> v = seocksDao.getBuyItem();

		ModelAndView mav = new ModelAndView("SeocksMain");

		MatchingBean mbean = (MatchingBean) session.getAttribute("mbean");
		if(mbean==null){
			mbean = new MatchingBean();			
		}
		//빈을 초기화
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

	
	//상품등록
	@RequestMapping("/shop/itemreserveform.do")
	public ModelAndView itemreserveform( HttpSession session) {
		
		return new ModelAndView("SeocksMain", "center", "ItemUpload.jsp");
	}
	
	//
	@RequestMapping("/shop/itemreserve.do")
	public String itemreserve(HttpServletRequest request) throws Exception {
		
		/*
		SeocksBean bean = null;
		// 각종 파일업로드 설정 변수 선언
		request.setCharacterEncoding("EUC-KR");
		// 최대 파일업로드될 데이터의 크기를 설정 10mbyte
		int maxSize = 1024 * 1024 * 10;
		String realfolder = "C:/MyWork/jsp/Project/WebContent/img";// 프로젝트에 폴더만든
		// 이름을 적으면됨
		try {
			// 클라이언트로부터 넘어온 데이터를 서버 상의 업로드 폴저에 저장하는 작업
			MultipartRequest multi = new MultipartRequest(request, realfolder, maxSize, "EUC-KR",
					new DefaultFileRenamePolicy());// 동일한 이름이 있다면 변경
			bean = new SeocksBean();
			bean.setPno(multi.getParameter("pno"));
			bean.setPname(multi.getParameter("pname"));
			bean.setPprice(Integer.parseInt(multi.getParameter("pprice")));
			bean.setPinfo(multi.getParameter("pinfo"));
			bean.setPcate(Integer.parseInt(multi.getParameter("pcate")));
			
			// 한개이상의 파일이 서버로 넘어왔다면
			Enumeration en = multi.getFileNames();
			String imgarr[] = new String[2];
			int i = 0;
			while (en.hasMoreElements()) {
				// 파일 이름 두개가 넘어옴
				String filename = en.nextElement().toString();
				imgarr[i] = multi.getOriginalFileName(filename);
				i++;
			}
			// 배열에 저장된 이미지를 bean에 다시저장
			bean.setPmainimg(imgarr[0]);
			bean.setPsubimg(imgarr[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(bean.getPno());
		// no값이 존재 하는지 여부를 파악
		int result = seocksDao.itemcheck(bean.getPno());
		// 결과가 0이라면 새롭게 저장
		if (result == 0) {
			seocksDao.insertItem(bean);
			return new ModelAndView("SeocksMain", "center", "UploadComplate.jsp");
		} else {
			// 이미 있는 상품이라면
			ModelAndView mav = new ModelAndView("SeocksMain");
			mav.addObject("center", "ItemUpload.jsp");
			mav.addObject("msg", "1");
			return mav;
		}
		*/
		
		return null;
	}
}
