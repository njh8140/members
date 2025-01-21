package kr.hkit.service;

import java.util.List;

import kr.hkit.domain.Criteria;
import kr.hkit.domain.MembersVO;

public interface MembersService {
	
	public void register(MembersVO members);
	
	public MembersVO get(long mno);
	
	public boolean modify(MembersVO members);
	
	public boolean remove(long mno);
	
	public List<MembersVO> getList(Criteria cri); //페이징 처리 o
	
	public int getTotal(Criteria cri);
	
}