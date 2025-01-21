package kr.hkit.mapper;

import java.util.List;

import kr.hkit.domain.Criteria;
import kr.hkit.domain.MembersVO;

public interface MembersMapper {
	
	//@Select("select * from tbl_board")
	public List<MembersVO> getList();

	public List<MembersVO> getListWithPaging(Criteria cri); // 페이징
	
	public void insert(MembersVO members); // 등록
	
	public void insertSelectKey(MembersVO members);
	
	public MembersVO read(long mno); //조건부 찾기

	public int delete(long mno); //조건부 삭제
	
	public int update(MembersVO members); //업데이트
	
	public int getTotal(Criteria cri);

}
