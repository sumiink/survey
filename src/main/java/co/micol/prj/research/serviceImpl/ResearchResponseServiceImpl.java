package co.micol.prj.research.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.research.map.ResearchResponseMap;
import co.micol.prj.research.service.ResearchResponseService;
import co.micol.prj.research.vo.ResearchResponseVO;

@Repository("responseDao")
public class ResearchResponseServiceImpl implements ResearchResponseService {
	@Autowired
	ResearchResponseMap map;

	@Override
	public List<ResearchResponseVO> responseList(ResearchResponseVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int responseInsert(List<ResearchResponseVO> list) {
		// TODO Auto-generated method stub
		return map.responseInsert(list);
	}
	
	

}
