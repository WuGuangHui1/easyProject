package Usecase.dao;

import java.util.List;
import java.util.Map;

import entity.Usecase;
import utils.DBUtil;

/**
 * @author ∂≈ˆŒ”Ó
 */
public class CaseDaoImpl {
	public List<Map<String, Object>> findAll() {
		return DBUtil.findAll("select * from usecase");
	}
	public List<Usecase> findAllCases() {
		return DBUtil.find(Usecase.class, "select * from usecase", null);
	}
	public int saveCase(Usecase case1) {
		return DBUtil.executeUpdate("insert into usecase(url,method,body) values (?,?,?)",
				new Object[] {case1.getUrl(),case1.getMethod(),case1.getBody()});
	}
	public Usecase findById(int id) {
		Object obj = DBUtil.findById(Usecase.class, id);
		return obj != null ? (Usecase) obj : null;
	}
	public int updateCases(Usecase cases) {
		return DBUtil.executeUpdate("update usecase set url=?,method=?,body=?  where id=?", 
				new Object[] { cases.getUrl(), cases.getMethod(),cases.getBody(),cases.getId() });
	}
	public int deleteCase(int id) {
		return DBUtil.executeUpdate("delete from usecase where id=?", new Object[] { id });
	}

}
