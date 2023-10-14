package org.iclass.mvc.controller;

import org.iclass.mvc.dto.OrderDto;
import org.iclass.mvc.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/order")
@Controller
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    @GetMapping("/orderForm")
    public void insert(){
        /* 주문 등록은 getMapping 은 보여주기 위함 */
    }
    
    @PostMapping("/orderForm")
    public String save(OrderDto vo, RedirectAttributes redirectAttributes){
        service.insert(vo);
        /* bidx 를 orderConfirm 에 넘겨줌 */
        redirectAttributes.addAttribute("bidx",vo.getBidx());
        
        return "redirect:/order/orderConfirm";
    }

    @GetMapping({"/orderConfirm","/update"})
    public void orderConfirm(@RequestParam("bidx") int bidx, Model model){
        OrderDto vo = service.selectByBidx(bidx);
        model.addAttribute("vo", vo);
        model.addAttribute("bidx",bidx);
    }

    @GetMapping("/orderList")
    public void orderList(Model model){
        List<String> list = service.selectOrderByEmail();
        model.addAttribute("list",list);
    }

    @GetMapping("/orderDetail")
    public void orderDetail(@RequestParam("email") String email, Model model){
        List<OrderDto> list = service.selectByEmail(email);
        model.addAttribute("list",list);
        model.addAttribute("email",email);
    }

   /* @GetMapping("/update")
    public void update(){

    }*/
    @PostMapping("/update")
    public String updatesave(OrderDto vo, RedirectAttributes redirectAttributes){
        service.update(vo);
        redirectAttributes.addAttribute("bidx",vo.getBidx());

        return "redirect:/order/orderConfirm?bidx="+vo.getBidx();
    }


}
