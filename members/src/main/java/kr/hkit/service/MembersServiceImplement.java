package kr.hkit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hkit.domain.Criteria;
import kr.hkit.domain.MembersVO;
import kr.hkit.mapper.MembersMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MembersServiceImplement implements MembersService {
	
	@Setter(onMethod_ = @Autowired)
	private MembersMapper mapper;
	
	@Override
	public void register(MembersVO members) {
		log.info("!!!!register : " + members);
		mapper.insertSelectKey(members);
	}

	@Override
	public MembersVO get(long mno) {
		log.info("!!!!get : " + mno);
		
		return mapper.read(mno);
	}

	@Override
	public boolean modify(MembersVO members) {
		log.info("!!!!modify : " + members);
		
		return mapper.update(members)==1;
	}

	@Override
	public boolean remove(long mno) {
		log.info("!!!!remove : " + mno);
		
		return mapper.delete(mno)==1;
	}

	@Override
	public List<MembersVO> getList(Criteria cri) {
		log.info("!!!!getList : ");
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");  
		
		return mapper.getTotal(cri);
	}
	
}