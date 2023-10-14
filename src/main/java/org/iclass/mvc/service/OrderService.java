package org.iclass.mvc.service;

import lombok.RequiredArgsConstructor;
import org.iclass.mvc.dao.OrderMapper;
import org.iclass.mvc.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper dao;

    public List<String> selectOrderByEmail(){
        return dao.selectOrderByEmail();
    }

    public int insert(OrderDto vo){
        return dao.insert(vo);
    }

    public List<OrderDto> selectByEmail(String email){
        return dao.selectByEmail(email);
    }
    public OrderDto selectByBidx(int bidx) {
        return dao.selectByBidx(bidx);
    }
    public int update(OrderDto vo){
        return dao.update(vo);
    }
}
