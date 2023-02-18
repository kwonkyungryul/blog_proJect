package shop.mtcoding.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.myblog.dto.UserReq.JoinReqDto;
import shop.mtcoding.myblog.handler.ex.CustomException;
import shop.mtcoding.myblog.model.User;
import shop.mtcoding.myblog.model.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    @Transactional
    public void 회원가입(JoinReqDto joinReqDto) { // 메서드가 동기화가 돼있지는 않기 때문에 여러 요청이 와도 메서드는 동시에 때려진다.
        User sameuser = userRepository.findByUsername(joinReqDto.getUsername());
        if (sameuser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }
        // 변경코드가 발동하면 락이 걸린다
        int result = userRepository.insert(joinReqDto.getUsername(), joinReqDto.getPassword(), joinReqDto.getEmail());

        if (result != 1) {
            throw new CustomException("요청하신 서비스가 정상 처리되지 않았습니다.");
        }
    }
}
