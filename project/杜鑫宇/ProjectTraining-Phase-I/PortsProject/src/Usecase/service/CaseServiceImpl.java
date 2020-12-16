package Usecase.service;

import java.util.List;
import java.util.Map;

import Usecase.dao.CaseDaoImpl;

import entity.Usecase;

/**
 * @author ¶ÅöÎÓî
 */
public class CaseServiceImpl {
	
	public List<Map<String, Object>> listUsecases() {
		return new CaseDaoImpl().findAll();
	}

	public List<Usecase> listAllCases() {
		return new  CaseDaoImpl().findAllCases();
	}

	public boolean addCase(Usecase usecase) {
		int count = new CaseDaoImpl().saveCase(usecase);
		return count > 0;
	}

	public Usecase getUsecase(int id) {
		return new CaseDaoImpl().findById(id);
	}

	public boolean editCase(Usecase usecase) {
		int count = new CaseDaoImpl().updateCases(usecase);
		return count > 0;
	}

	public boolean dropCase(int id) {
		int count = new CaseDaoImpl().deleteCase(id);
		return count > 0;
	}

}
