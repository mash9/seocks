package com.seocks.old.control;

import java.util.Vector;

import com.seocks.old.model.ItembuyBean;


public class Cart {
	Vector<ItembuyBean> cartvec = new Vector<>();


	//기존 백터에 상품을 추가시켜주는 메소드를 작성
	public void insertCart(ItembuyBean bean){
		//기존 상품이 있는지의 여부를 파악 변수
		boolean flag =false;
		//백터의 끝까지 돌리면서 기존 상품과 비교
		for (int i = 0; i < cartvec.size(); i++) {
			//백터에 저장된 데이터를 하나씩추출
			ItembuyBean ibean = cartvec.get(i);
			//기존 상품번호와 비교한후 같다면 
			if(ibean.getPno().equals(bean.getPno())){
				//수량만 증가시키시오
				ibean.setQty(ibean.getQty()+bean.getQty());//총수량
				ibean.setTotalprice(ibean.getTotalprice()+bean.getTotalprice());//총가격
				flag=true;
				break;
			}
		}

		//만약 기존 상품이 없었다면
		if(flag==false){
			//백터에 새롭게 추가
			cartvec.add(bean);
		}

	}

	//모든 백터의 내용을 리턴하는 메소드
	public Vector<ItembuyBean> getAllCart(){

		return cartvec;
	}
	//백터에 해당 상품을 삭제
	public void delCart(String pno) {

		for (int i = 0; i < cartvec.size(); i++) {
			//백터에 해당 상품을 삭제
			ItembuyBean ibean = cartvec.get(i);
			if(ibean.getPno().equals(pno)){//해당 데이터가 있다면
				cartvec.remove(i);
				break;
			}

		}
	}
	//모든 아이템을 삭제 
	public void delAllCart() {

		cartvec.removeAllElements();

	}

}