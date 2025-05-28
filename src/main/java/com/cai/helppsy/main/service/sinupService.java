package com.cai.helppsy.main.service;



import com.cai.helppsy.main.entity.SinupEntity;
import com.cai.helppsy.main.repository.sinupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class sinupService {

    private final sinupRepository sinuprepository;

    // 회원가입
    public void sinup(SinupEntity sinupentity){ // 회원가입
        sinuprepository.save(sinupentity);
    }

    // 회원 별칭 가져오기 (세션유지용)
    public SinupEntity login(String userId){
        return sinuprepository.findByuserId(userId);
   }


}
