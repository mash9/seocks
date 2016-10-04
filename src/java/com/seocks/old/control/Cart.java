package com.seocks.old.control;

import java.util.Vector;

import com.seocks.old.model.ItembuyBean;


public class Cart {
	Vector<ItembuyBean> cartvec = new Vector<>();


	//���� ���Ϳ� ��ǰ�� �߰������ִ� �޼ҵ带 �ۼ�
	public void insertCart(ItembuyBean bean){
		//���� ��ǰ�� �ִ����� ���θ� �ľ� ����
		boolean flag =false;
		//������ ������ �����鼭 ���� ��ǰ�� ��
		for (int i = 0; i < cartvec.size(); i++) {
			//���Ϳ� ����� �����͸� �ϳ�������
			ItembuyBean ibean = cartvec.get(i);
			//���� ��ǰ��ȣ�� ������ ���ٸ� 
			if(ibean.getPno().equals(bean.getPno())){
				//������ ������Ű�ÿ�
				ibean.setQty(ibean.getQty()+bean.getQty());//�Ѽ���
				ibean.setTotalprice(ibean.getTotalprice()+bean.getTotalprice());//�Ѱ���
				flag=true;
				break;
			}
		}

		//���� ���� ��ǰ�� �����ٸ�
		if(flag==false){
			//���Ϳ� ���Ӱ� �߰�
			cartvec.add(bean);
		}

	}

	//��� ������ ������ �����ϴ� �޼ҵ�
	public Vector<ItembuyBean> getAllCart(){

		return cartvec;
	}
	//���Ϳ� �ش� ��ǰ�� ����
	public void delCart(String pno) {

		for (int i = 0; i < cartvec.size(); i++) {
			//���Ϳ� �ش� ��ǰ�� ����
			ItembuyBean ibean = cartvec.get(i);
			if(ibean.getPno().equals(pno)){//�ش� �����Ͱ� �ִٸ�
				cartvec.remove(i);
				break;
			}

		}
	}
	//��� �������� ���� 
	public void delAllCart() {

		cartvec.removeAllElements();

	}

}