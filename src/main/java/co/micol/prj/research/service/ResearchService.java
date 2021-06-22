package co.micol.prj.research.service;


import java.util.List;

import co.micol.prj.research.vo.ResearchVO;

public interface ResearchService {
	List<ResearchVO> researchSelectList();
	ResearchVO researchSelect(ResearchVO vo);
	int researchInsert(ResearchVO vo);
	int researchUpdate(ResearchVO vo);
	int researchDelete(ResearchVO vo);
}
