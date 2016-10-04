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

	// 초기화면 4개의 아우터 이미지를 리턴할 메소드
	public List<SeocksBean> getFourCon(int pcate) {
		String sql = "select * from shopping where pcate=?";
		// row와 bean클래스를 맵핑
		RowMapper<SeocksBean> rm = new BeanPropertyRowMapper<>(SeocksBean.class);
		// 홈데이터 갯수만큼 list타입으로 리턴됨
		return template.query(sql, rm, pcate);
	}

	// 하나의 상품 이미지를 리턴하는 메소드
	public SeocksBean getOneCon(String pno) {
		String sql = "select * from shopping where pno=?";
		// row 와 bean 클래스를 맵핑
		RowMapper<SeocksBean> rm = new BeanPropertyRowMapper<>(SeocksBean.class);
		return template.queryForObject(sql, rm, pno);
	}

	public List<SeocksBean> getAllCon() {
		String sql = "select * from shopping";
		// row와 bean클래스를 맵핑
		RowMapper<SeocksBean> rm = new BeanPropertyRowMapper<>(SeocksBean.class);
		// 홈데이터 갯수만큼 list타입으로 리턴됨
		return template.query(sql, rm);
	}

	// 회원가입 버튼 클릭시 실행되는 메소드
	public void insertMember(MemberBean bean) {
		// 쿼리작성
		String sql = "insert into jspmember values(:id,:pass,:name,:email,:mtemp,:maddress1,:maddress2,:gender,:birthday,:info)";

		// 빈클래스와 sql문을 자동으로 맵핑하는 클래스 선언
		SqlParameterSource source = new BeanPropertySqlParameterSource(bean);
		// 데이터베이스에 저장
		template.update(sql, source);
	}

	// 맴버리스트를 리턴하는 메소드
	public List<MemberBean> getAllMember() {
		// 쿼리작성
		String sql = "select * from jspmember";
		// 컬럼과 빈클래스를 이용하여 데이터를 맵핑
		RowMapper<MemberBean> rm = new BeanPropertyRowMapper<>(MemberBean.class);
		return template.query(sql, rm);
	}

	// 한 회원만 리턴하는 메소드
	public MemberBean getOneMember(String id) {
		// 쿼리작성
		String sql = "select * from jspmember where id=?";
		RowMapper<MemberBean> rm = new BeanPropertyRowMapper<>(MemberBean.class);
		return template.queryForObject(sql, rm, id);
	}

	// 아이디, 비밀번호 리턴하는 메소드
	public int logindb(MemberBean bean) {

		String sql = "select count(*) from jspmember where id=? and pass=?";

		return template.queryForInt(sql, bean.getId(), bean.getPass());
	}

	// 하나의 상품을 리턴하는 메소드
	public SeocksBean getOneItem(String pno) {

		String sql = "select * from shopping where pno=?";
		RowMapper<SeocksBean> rm = new BeanPropertyRowMapper<>(SeocksBean.class);
		return template.queryForObject(sql, rm, pno);
	}

	// 상품을 결제하는 메소드
	public void insertItembuy(ItembuyBean bean) {

		String sql = "insert into shoppingitem values (item_seq.NEXTVAL,:pno,:pname,:pprice,:pmainimg,:pcate,:psize,:qty,:totalprice,sysdate,:temp)";

		SqlParameterSource source = new BeanPropertySqlParameterSource(bean);
		// 데이터베이스에 저장
		template.update(sql, source);
	}
	// 상품을 결제하는 메소드
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
		// 데이터베이스에 저장
		template.update(sql, source);
	}

	// 회원이 구매한 모든 정보
	public List<ItembuyBean> getAllItem(String id) {
		String sql = "select * from SHOPPINGITEM where temp=?";
		RowMapper<ItembuyBean> rm = new BeanPropertyRowMapper<>(ItembuyBean.class);
		return template.query(sql, rm, id);
	}

	//판매현황
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
		  // 해당 상품 번호가 있는지여부 파악
		  String sql = "select count(*) from shopping where pno = ? ";
		  return template.queryForInt(sql, no);
		 }
}
