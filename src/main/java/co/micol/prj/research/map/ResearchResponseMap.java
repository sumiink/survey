package co.micol.prj.research.map;

import java.util.List;

import co.micol.prj.research.vo.ResearchResponseVO;

public interface ResearchResponseMap {
	
	List<ResearchResponseVO> researchSelectList();
	int responseInsert(List<ResearchResponseVO> list);
}
