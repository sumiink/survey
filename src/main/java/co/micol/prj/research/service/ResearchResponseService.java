package co.micol.prj.research.service;

import java.util.List;

import co.micol.prj.research.vo.ResearchResponseVO;

public interface ResearchResponseService {
	List<ResearchResponseVO> responseList(ResearchResponseVO vo);
	int responseInsert(List<ResearchResponseVO> list);
}
