package com.seocks.old.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.web.servlet.ModelAndView;

public class SeocksDAO {
	


	DataSource dataSource;
	SimpleJdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new SimpleJdbcTemplate(dataSource);
	}

	// �ʱ�ȭ�� 4���� �ƿ��� �̹����� ������ �޼ҵ�
	public List<SeocksBean> getFourCon(int pcate) {
		String sql = "select * from shopping where pcate=?";
		// row�� beanŬ������ ����
		RowMapper<SeocksBean> rm = new BeanPropertyRowMapper<>(SeocksBean.class);
		// Ȩ������ ������ŭ listŸ������ ���ϵ�
		return template.query(sql, rm, pcate);
	}

	// �ϳ��� ��ǰ �̹����� �����ϴ� �޼ҵ�
	public SeocksBean getOneCon(String pno) {
		String sql = "select * from shopping where pno=?";
		// row �� bean Ŭ������ ����
		RowMapper<SeocksBean> rm = new BeanPropertyRowMapper<>(SeocksBean.class);
		return template.queryForObject(sql, rm, pno);
	}

	public List<SeocksBean> getAllCon() {
		String sql = "select * from shopping";
		// row�� beanŬ������ ����
		RowMapper<SeocksBean> rm = new BeanPropertyRowMapper<>(SeocksBean.class);
		// Ȩ������ ������ŭ listŸ������ ���ϵ�
		return template.query(sql, rm);
	}

	// ȸ������ ��ư Ŭ���� ����Ǵ� �޼ҵ�
	public void insertMember(MemberBean bean) {
		// �����ۼ�
		String sql = "insert into jspmember values(:id,:pass,:name,:email,:mtemp,:maddress1,:maddress2,:gender,:birthday,:info)";

		// ��Ŭ������ sql���� �ڵ����� �����ϴ� Ŭ���� ����
		SqlParameterSource source = new BeanPropertySqlParameterSource(bean);
		// �����ͺ��̽��� ����
		template.update(sql, source);
	}

	// �ɹ�����Ʈ�� �����ϴ� �޼ҵ�
	public List<MemberBean> getAllMember() {
		// �����ۼ�
		String sql = "select * from jspmember";
		// �÷��� ��Ŭ������ �̿��Ͽ� �����͸� ����
		RowMapper<MemberBean> rm = new BeanPropertyRowMapper<>(MemberBean.class);
		return template.query(sql, rm);
	}

	// �� ȸ���� �����ϴ� �޼ҵ�
	public MemberBean getOneMember(String id) {
		// �����ۼ�
		String sql = "select * from jspmember where id=?";
		RowMapper<MemberBean> rm = new BeanPropertyRowMapper<>(MemberBean.class);
		return template.queryForObject(sql, rm, id);
	}

	// ���̵�, ��й�ȣ �����ϴ� �޼ҵ�
	public int logindb(MemberBean bean) {

		String sql = "select count(*) from jspmember where id=? and pass=?";

		return template.queryForInt(sql, bean.getId(), bean.getPass());
	}

	// �ϳ��� ��ǰ�� �����ϴ� �޼ҵ�
	public SeocksBean getOneItem(String pno) {

		String sql = "select * from shopping where pno=?";
		RowMapper<SeocksBean> rm = new BeanPropertyRowMapper<>(SeocksBean.class);
		return template.queryForObject(sql, rm, pno);
	}

	// ��ǰ�� �����ϴ� �޼ҵ�
	public void insertItembuy(ItembuyBean bean) {

		String sql = "insert into shoppingitem values (item_seq.NEXTVAL,:pno,:pname,:pprice,:pmainimg,:pcate,:psize,:qty,:totalprice,sysdate,:temp)";

		SqlParameterSource source = new BeanPropertySqlParameterSource(bean);
		// �����ͺ��̽��� ����
		template.update(sql, source);
	}
	// ��ǰ�� �����ϴ� �޼ҵ�
	public void insertItembuy2(SeocksBean buybean, String psize, String pno, int qty,String id) {
		System.out.println(buybean.getPno());
		System.out.println(qty);
		System.out.println(psize);
		System.out.println(buybean.getPname());
		System.out.println(buybean.getPprice());
		System.out.println(buybean.getPmainimg());
		System.out.println(buybean.getPcate());
		System.out.println(id);
		
		int totalp = qty * buybean.getPprice();
		String sql = "insert into shoppingitem values (item_seq.NEXTVAL, :pno, :pname, :pprice, :pmainimg, :pcate,'" + psize + "', " + qty +", " + totalp + ",sysdate,'" + id + "')";
		SqlParameterSource source = new BeanPropertySqlParameterSource(buybean);
		// �����ͺ��̽��� ����
		template.update(sql, source);
	}

	// ȸ���� ������ ��� ����
	public List<ItembuyBean> getAllItem(String id) {
		String sql = "select * from SHOPPINGITEM where temp=?";
		RowMapper<ItembuyBean> rm = new BeanPropertyRowMapper<>(ItembuyBean.class);
		return template.query(sql, rm, id);
	}

	//�Ǹ���Ȳ
	public List<ItembuyBean> getBuyItem() {
		String sql = "select * from SHOPPINGITEM order by reg_date desc";
		RowMapper<ItembuyBean> rm = new BeanPropertyRowMapper<>(ItembuyBean.class);
		return template.query(sql, rm);
	}
	
	public void insertItem(SeocksBean bean) {
		  String sql = "insert into shopping values(:pno,:pname,:pprice,:pinfo,:pmainimg,:psubimg, 0 ,:pcate,' ')";
		  SqlParameterSource source = new BeanPropertySqlParameterSource(bean);
		  template.update(sql, source);
		 }

		public int itemcheck(String no) {
		  // �ش� ��ǰ ��ȣ�� �ִ������� �ľ�
		  String sql = "select count(*) from shopping where pno = ? ";
		  return template.queryForInt(sql, no);
		 }
}
